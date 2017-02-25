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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maanas.daos.ClassDao;
import com.maanas.daos.UserDao;
import com.maanas.models.Class;
import com.maanas.models.User;
import com.maanas.util.MessageResponse;

@CrossOrigin(maxAge = 3600)
@ManagedBean
@RestController
@RequestMapping(value = "/rest/class", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/rest/class", description = "API for class mamagement")
public class ClassController {

	@Autowired
	private ClassDao classdoa;
	
	@RequestMapping(method = RequestMethod.POST, path = "/")
	@ApiOperation(value = "Add new class", notes = "Add new class with basic details.")
	public ResponseEntity<MessageResponse> createClass(
			@Validated @RequestBody Class clas) {
		String classId = "";
		try {
			Class classnew = classdoa.save(clas);
			classId = String.valueOf(classnew.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
			return MessageResponse.failureOk("Error while creating class: "
					+ ex.getMessage());
		}
		return MessageResponse.successOk("Class succesfully created with id = "
				+ classId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ApiOperation(value = "delete class", notes = "Delete class using id.")
	public String delete(
			@ApiParam(name = "id", required = true) @NotNull @PathVariable("id") Long id) {
		try {
			Class clas = classdoa.findOne(id);
			if (clas != null) {
				classdoa.delete(clas);
			} else {
				return "Error deleting the class: class doesn't exist";
			}
		} catch (Exception ex) {
			return "Error deleting the class:" + ex.toString();
		}
		return "Class succesfully deleted!";
	}
}
