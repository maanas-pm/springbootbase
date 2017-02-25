package com.maanas.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String email;

	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String gender;
	
	@NotNull
	private String dob;
	
	@NotNull
	private String Address;
	
	@NotNull
	private String mobile;

	@NotNull
	private String yoj;
	
	@NotNull
	private boolean isAlumini;
	
	@ManyToOne
	private Class clas;

	public User(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getYoj() {
		return yoj;
	}

	public void setYoj(String yoj) {
		this.yoj = yoj;
	}

	public boolean isAlumini() {
		return isAlumini;
	}

	public void setAlumini(boolean isAlumini) {
		this.isAlumini = isAlumini;
	}

	public Class getClas() {
		return clas;
	}

	public void setClas(Class clas) {
		this.clas = clas;
	}

}
