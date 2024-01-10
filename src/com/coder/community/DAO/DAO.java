package com.coder.community.DAO;

import java.util.List;

import com.coder.community.entity.User;

public interface DAO {

	public void saveCustomer(User theUser);

	public User validate(String email, String password);

	public List<User> getCustomer();

	public void editCustomer(User theUser);

	public User updateUser(int theId);

	void UpdateSaveUser(User theUser);

	public void delteUser(int theId);

	List<User> getCustomerUser();
}
