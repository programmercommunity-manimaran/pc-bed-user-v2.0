package com.programmercommunity.hicks.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmercommunity.hicks.user.exception.UserNotFound;
import com.programmercommunity.hicks.user.model.Response;
import com.programmercommunity.hicks.user.model.User;
import com.programmercommunity.hicks.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public User getUserById(String id, String email) {
		if (this.userRepository.existsById(email)) {
			User user = this.userRepository.findById(email).get();
			if (user.getId().equals(id)) {
				return this.userRepository.findById(email).get();
			}
			throw new UserNotFound("User Not Found");
		}
		throw new UserNotFound("User Not Found");
	}

	public User getUserByEmail(String email) {
		if (this.userRepository.existsById(email)) {
			return this.userRepository.findById(email).get();
		}
		throw new UserNotFound("User Not Found");
	}

	public Response getValidEmail(String email) {
		if (this.userRepository.existsById(email)) {
			return  new Response(200,"Email Exist");
		}
		return new Response(200, "Success");
	}

	public Response getValidUser(String email, String password) {
		if (this.userRepository.existsById(email)) {
			User user = this.userRepository.findById(email).get();
			if (user.getPassword().equals(password)) {
				return new Response(200, "Success");
			}
			throw new UserNotFound("Username and password mismatch");
		}
		throw new UserNotFound("Username and password mismatch");
	}

	public Response addUser(User user) {
		if (this.userRepository.existsById(user.getEmail())) {
			return new Response(200, "Email Exist");
		}
		this.userRepository.save(user);
		return new Response(200, "Success");
	}

	public Response updateUser(User user) {
		if (this.userRepository.existsById(user.getEmail())) {
			this.userRepository.save(user);
			return new Response(200, "Success");
		}
		throw new UserNotFound("Mail already exists");
	}

	public Response verifyUser(String email) {
		if (this.userRepository.existsById(email)) {
			User user = this.userRepository.findById(email).get();
			user.setVerified(true);
			this.userRepository.save(user);
			return new Response(200, "Success");

		}
		throw new UserNotFound("User Not Found");
	}

	public Response updatePassword(String email, String password) {
		if (this.userRepository.existsById(email)) {
			User user = this.userRepository.findById(email).get();
			user.setPassword(password);
			this.userRepository.save(user);
			return new Response(200, "Success");
		}
		throw new UserNotFound("User Not Found");
	}

	public Response DeleteUserByEmail(String email) {
		if (this.userRepository.existsById(email)) {
			this.userRepository.deleteById(email);
			return new Response(200, "Success");
		}
		throw new UserNotFound("User Not Found");
	}
}
