package com.maanas.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maanas.daos.UserDao;
import com.maanas.models.User;
import com.maanas.util.MessageResponse;

@CrossOrigin(maxAge = 3600)
@ManagedBean
@RestController
@RequestMapping(value = "/rest/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/rest/user", description = "API for user mamagement")
public class UserController {

	/**
	 * GET /create --> Create a new user and save it in the database.
	 */

	@Autowired
	private UserDao userDao;

	@RequestMapping(method = RequestMethod.POST, path = "/")
	@ApiOperation(value = "Add new user", notes = "Add new user with basic details.")
	public ResponseEntity<MessageResponse> createUser(
			@Validated @RequestBody User user) {
		String userId = "";
		try {
			userDao.save(user);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
			return MessageResponse.failureOk("Error while creating user: "
					+ ex.getMessage());
		}
		return MessageResponse.successOk("User succesfully created with id = "
				+ userId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	@ApiOperation(value = "search user", notes = "Search user using id.")
	public ResponseEntity<User> getUser(
			@ApiParam(name = "id", required = true) @NotNull @PathVariable("id") Long id) {
		try {
			User user = userDao.findOne(id);
			if (user != null) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * GET /delete --> Delete the user having the passed id.
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ApiOperation(value = "delete user", notes = "Delete user using id.")
	public String delete(
			@ApiParam(name = "id", required = true) @NotNull @PathVariable("id") Long id) {
		try {
			User user = userDao.findOne(id);
			if (user != null) {
				userDao.delete(user);
			} else {
				return "Error deleting the user: user doesn't exist";
			}
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}
}
