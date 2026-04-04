package com.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.entity.User;
import com.finance.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// CREATE
	public User createUser(User user) {
		if (user == null) {
			throw new RuntimeException("User cannot be null");
		}
		return userRepository.save(user);
	}

	// READ ALL
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	//READ BY ID
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}

	//UPDATE
	public User updateUser(Long id, User updatedUser) {

		if (updatedUser == null) {
			throw new RuntimeException("Updated user data cannot be null");
		}

		User existing = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

		existing.setName(updatedUser.getName());
		existing.setEmail(updatedUser.getEmail());
		existing.setPassword(updatedUser.getPassword());
		existing.setRole(updatedUser.getRole());
		existing.setActive(updatedUser.getActive());

		return userRepository.save(existing);
	}

	//DELETE
	public void deleteUser(Long id) {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

		userRepository.delete(user);
	}
}