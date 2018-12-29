package com.gemfire.demo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Region(name="person")
public class Person implements Serializable{

	@Id
	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String name;
	
	@PersistenceConstructor
	public Person(Integer id, String name) {
		this.id=id;
		this.name=name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
