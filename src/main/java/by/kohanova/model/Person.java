package by.kohanova.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import by.kohanova.model.enums.RoleEnum;

/**
 * Role entity class
 */
@Entity
@Table(name = "persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	public Long personId;

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
	 * ManyToMany relation to {@link Role} entities
	 */
	@ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
	@JoinTable(name = "roles", joinColumns = { @JoinColumn(name = "person_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Role> roles;

	/**
	 * Getter method returns {@link User}'s collection of role names
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<RoleEnum> currentRoles = new ArrayList<>();
		for (Role role : roles)
			currentRoles.add(role.name);
		return currentRoles;
	}
}