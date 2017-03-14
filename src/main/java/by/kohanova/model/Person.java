package by.kohanova.model;

import javax.persistence.*;

/**
 * Role entity class
 */
@Entity
@Table(name = "persons")
public class Person {	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;
	
	/**
	 * Field of person's name
	 */
	@Column(name = "name")
	public String name;
	
	/**
	 * Field of person's surname
	 */
	@Column(name = "surname")
	public String surname;
	
	/**
	 * Field of person's email
	 */
	@Column(name = "email")
	public String email;
	
	/**
	 * Field of person's photo
	 */
	@Column(name = "photo")
	public String photo;
	
	/**
	 * Field of person's login
	 */
	@Column(name = "login")
	public String login;
	
	/**
	 * Field of person's password
	 */
	@Column(name = "password")
	public String password;
	
	/**
	 * Field of person's role_id
	 */
	@Column(name = "role_id")
	public String roleId;
}