package by.kohanova.model;

import javax.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * User entity class
 */
@Entity
@Table(name = "users")
public class Users extends AbstractPersistable<Integer> {
	private static final long serialVersionUID = 1L;

	/**
	 * Field of user name
	 */
	@Column(name = "name")
	public String name;

	/**
	 * Field of user age
	 */
	@Column(name = "age")
	public Integer age;
}