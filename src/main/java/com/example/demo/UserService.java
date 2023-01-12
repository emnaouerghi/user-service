package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	PasswordEncoder passwordEncoder;

	public UserService() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public User saveUser(User u) {
		String encodedPassword = this.passwordEncoder.encode(u.getPassword());
		u.setPassword(encodedPassword);
		return userRepository.save(u);
	}

	public User updateUser(User u) {
		return userRepository.save(u);
	}

	public void deleteUser(User u) {
		userRepository.delete(u);

	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);

	}

	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

}
