package com.gemfire.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Region(name="person")
public class Person {

	@Id
	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String name;
	
	public Person(Integer id, String name) {
		this.id=id;
		this.name=name;
	}
}
