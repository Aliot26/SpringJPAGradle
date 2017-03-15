package by.kohanova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import by.kohanova.model.Person;
import by.kohanova.repository.PersonRepository;
import by.kohanova.service.PersonService;

public class PersonServiceImpl implements PersonService{

	@Autowired
    private PersonRepository personRepository;
	
	@Override
	public Person find(Integer id) {
		return personRepository.findPerson(id);
	}

}
