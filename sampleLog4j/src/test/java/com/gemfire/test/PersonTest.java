package com.gemfire.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.gemfire.demo.GemfireConfig;
import com.gemfire.demo.Person;
import com.gemfire.demo.PersonRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=GemfireConfig.class,loader=AnnotationConfigContextLoader.class)
public class PersonTest {
	
	@Autowired
	private PersonRepository reposiroty;
	
	@Test
	public void savePerson() {
		Person person = new Person(12,"arun");
		reposiroty.save(person);
		
		List<Person> list = (List<Person>) reposiroty.findAll();
		assertEquals(1, list.size());
		
	}
	
	@Test
	public void findByName() {
		String name = "prasad";
		
		Person p1 = new Person(13,name);
		reposiroty.save(p1);
		
		Person  person2 = reposiroty.findByName("prasad");
		assertEquals(name, person2.getName());
	}

}
