package com.coder.community.DAO;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.coder.community.entity.User;

public interface DAO {

	public void saveCustomer(User theUser);

	public User validate(String email, String password);

	public List<User> getCustomer();

	public void editCustomer(User theUser);

	public List<User> updateUser(int theId);

	void UpdateSaveUser(User theUser);

	public void delteUser(int theId);

	List<User> getCustomerUser();

	public void saveImage(CommonsMultipartFile file);

	List<User> getCustomerWithImages();

	User updateUsercurret(int theId);
}
