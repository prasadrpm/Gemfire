package com.gemfire.demo;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableGemfireRepositories
public interface PersonRepository extends CrudRepository<Person, Integer>{

}
