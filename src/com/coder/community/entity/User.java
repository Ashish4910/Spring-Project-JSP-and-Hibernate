package com.coder.community.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "email")

	private String email;

	@Column(name = "phone")
	private long phone;

	@Column(name = "designation")
	private String designation;

	@Column(name = "password")
	private String password;

	@Lob
	@Column(name = "image")
	private String image;

	public User(String fullName, String email, long phone, String designation, String password, String image) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
		this.password = password;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String fullName, String email, long phone, String designation, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
		this.password = password;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone + ", designation="
				+ designation + ", password=" + password + ", image=" + image + "]";
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

}
