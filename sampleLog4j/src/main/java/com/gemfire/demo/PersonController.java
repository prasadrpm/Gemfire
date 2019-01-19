package com.gemfire.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ComponentScan
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(method=RequestMethod.POST ,path="/save")
	public String savePerson(@RequestParam Integer id, @RequestParam String name) {
		Person person = new Person(id, name);
		personRepository.save(person);
		return name+"is saved in Gemfire cache";
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/find")
	public String savePerson(@RequestParam String name) {
		return personRepository.findByName(name).toString();
	}
	@RequestMapping(method=RequestMethod.POST,path="/count")
	public Integer count() {
		return (int) personRepository.findAll().spliterator().estimateSize();
	}
	@RequestMapping(method=RequestMethod.POST,path="/deleteAll")
	public void deleteAll() {
		 personRepository.deleteAll();
	}
	
}
