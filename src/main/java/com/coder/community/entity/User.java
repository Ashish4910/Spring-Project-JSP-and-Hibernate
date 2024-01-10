package com.coder.community.entity;

import javax.persistence.Column;
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

	
	public User(int id, String fullName, String email, String phone, String designation, String password,
			byte[] image) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
		this.password = password;
		this.image = image;
	}

	@Column(name = "phone")
	private String phone;

	public User(int id, String fullName, String email, String phone, String designation, String password, byte[] image,
			String imageBase64) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
		this.password = password;
		this.image = image;
		this.imageBase64 = imageBase64;
	}

	@Column(name = "designation")
	private String designation;

	@Column(name = "password")
	private String password;

	/*
	 * @Column(name = "image") private String image;
	 */
	/* , columnDefinition = "BLOB" */
	@Lob
	@Column(name = "image")
	private byte[] image;

	@Column(name = "imageBase64")
	private String imageBase64;

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	public User(String fullName, String email, String phone, String designation, String password, byte[] image) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
		this.password = password;
		this.image = image;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone2) {
		this.phone = phone2;
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

	public User(String fullName, String email, String phone, String designation, String password) {
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
