package by.kohanova.model;

import by.kohanova.model.enums.RoleEnum;
import javax.persistence.*;

/**
 * Role entity class
 */
@Entity
@Table(name = "roles")
public class Role {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	public Integer roleId;

	/**
	 * Field of role type
	 */
	@Enumerated(EnumType.STRING)
	public RoleEnum name;

}