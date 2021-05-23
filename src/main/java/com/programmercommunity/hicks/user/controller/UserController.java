package com.programmercommunity.hicks.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.programmercommunity.hicks.user.assets.Paths;
import com.programmercommunity.hicks.user.model.Response;
import com.programmercommunity.hicks.user.model.User;
import com.programmercommunity.hicks.user.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	
	@GetMapping(Paths.UserControllerPaths.GET_ALL_USERS)
	public @ResponseBody List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@GetMapping(Paths.UserControllerPaths.GET_USER_BY_ID)
	public @ResponseBody User getUserById(String id, String email) {
		return this.userService.getUserById(id, email);
	}

	@GetMapping(Paths.UserControllerPaths.GET_USER_BY_EMAIL)
	public @ResponseBody User getUserByIEmail(@PathVariable("email") String email) {
		return this.userService.getUserByEmail(email);
	}

	@GetMapping(Paths.UserControllerPaths.GET_VAILD_EMAIL)
	public @ResponseBody Response getValidEmail(@PathVariable("email") String email) {
		return this.userService.getValidEmail(email);
	}

	@GetMapping(Paths.UserControllerPaths.GET_VALID_USER)
	public @ResponseBody Response getValidUser(@RequestParam("password") String password,
			@RequestParam("email") String email) {
		return this.userService.getValidUser(email, password);
	}

	@PostMapping(Paths.UserControllerPaths.POST_ADD_USER)
	public @ResponseBody Response adduser(@RequestBody User user) {
		return this.userService.addUser(user);
	}

	@PutMapping(Paths.UserControllerPaths.PUT_UPDATE_USER)
	public @ResponseBody Response updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}

	@PutMapping(Paths.UserControllerPaths.PUT_VERIFY_USER)
	public @ResponseBody Response verifyUser(@PathVariable("email") String email) {
		return this.userService.verifyUser(email);
	}

	@PutMapping(Paths.UserControllerPaths.PUT_UPDATE_USER_PASSWORD)
	public @ResponseBody Response updatePassword(@RequestParam("password") String password,
			@RequestParam("email") String email) {
		return this.userService.updatePassword(email, password);
	}

	@DeleteMapping(Paths.UserControllerPaths.DELETE_USER_BY_EMAIL)
	public @ResponseBody Response deleteUser(@PathVariable("email") String email) {
		return this.userService.DeleteUserByEmail(email);
	}
}
