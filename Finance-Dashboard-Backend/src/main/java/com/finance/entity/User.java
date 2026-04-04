package com.finance.entity;

import com.finance.enums.Role;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Name required
	@NotBlank(message = "Name is required")
	private String name;

	// Valid email required
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	private String email;

	// Password required
	@NotBlank(message = "Password is required")
	private String password;

	// Role required
	@NotNull(message = "Role is required")
	@Enumerated(EnumType.STRING)
	private Role role;

	// Active status required
	@NotNull(message = "Active status is required")
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}