package by.kohanova.service;

import by.kohanova.model.Person;

/**
 * Service for {@link Person}
 */
public interface PersonService {
	Person find(Integer id);
}
