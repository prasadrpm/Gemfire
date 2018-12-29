package com.gemfire.demo;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

	public Person findByName(String Name);
}
