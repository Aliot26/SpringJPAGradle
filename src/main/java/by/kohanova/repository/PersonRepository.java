package by.kohanova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.kohanova.model.Person;


/**
 * Abstract repository wrapper to communicate with database
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

	/**
	 * Method to find person from database by person id
	 * 
	 * @param name - person id
	 * @return  {@link Person}
	 */
	@Query("select u from Persons p where p.id = :personid")
	Person find(@Param("personid") Integer id);
}

