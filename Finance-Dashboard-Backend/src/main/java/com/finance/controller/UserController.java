package com.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finance.entity.User;
import com.finance.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	//CREATE
	@PostMapping
	public User createUser(@RequestBody @Valid User user) {
		return service.createUser(user);
	}

	//GET ALL
	@GetMapping
	public List<User> getUsers() {
		return service.getAllUsers();
	}

	//GET BY ID
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return service.getUserById(id);
	}

	//UPDATE
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
		return service.updateUser(id, user);
	}

	//DELETE
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return "User deleted successfully";
	}
}