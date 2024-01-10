package com.coder.community.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coder.community.entity.User;
import com.mysql.cj.protocol.Resultset;

@Repository
public class DAOImpl implements DAO {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	@Transactional
	public void saveCustomer(User theUser) {

		Session currSession = sessionFactory.getCurrentSession();

		currSession.save(theUser);
	}
//
//	@Override
//	public User validate(String email, String password) {
//
//
//		Session currSession = sessionFactory.getCurrentSession();
//		
//		Query theQuery = currSession.createQuery("select * from registration where Email =:email and Password =:password");
//		
//		 theQuery.setParameter("Email", email);
//		 theQuery.setParameter("Password", password);
//		 
//		Resultset rs = theQuery.executeQuery();
//		
//		if(rs.getNextResultset() != null) {
//			
//		
//		}
//		
//		
//		return null;
//	}

//	@Override
//	@Transactional
//	public User validate(String email, String password) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		String hql = "FROM User u WHERE u.email = :email AND u.password = :password";
//
//		Query<User> query = currentSession.createQuery(hql, User.class);
//		query.setParameter("email", email);
//		query.setParameter("password", password);
//
//		System.out.println("Email: " + email); // Add this for debugging
//		System.out.println("Password: " + password); // Add this for debugging
//
//		List<User> users = query.getResultList();
//
////		if(users.containsAll(getCustomer())) {
////			System.out.println("Contain value ");
////		}
////		if (!users.isEmpty()) {
////			User validateUser = users.get(0);
////			System.out.println("validation 1 " + validateUser);
////
////			return validateUser;
////		} 
////		
//		if (!users.isEmpty()) {
//			User validateUser = users.get(0);
//			System.out.println("Validate 1 " + validateUser);
//			return validateUser;
//		}
//
//		else {
//			return null;
//		}
//
//	}

	@Override
	@Transactional
	public User validate(String email, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hql = "FROM User u WHERE u.email = :email AND u.password = :password";

		Query<User> query = currentSession.createQuery(hql, User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);

		System.out.println("Email: " + email); // Add this for debugging
		System.out.println("Password: " + password); // Add this for debugging

		List<User> users = query.getResultList();

		if (!users.isEmpty()) {
			User validateUser = users.get(0);
			System.out.println("Validate user method " + validateUser.getDesignation());
			System.out.println("Validation successful for user: " + validateUser.getEmail());
			return validateUser;
		} else {
			System.out.println("Validation failed for email: " + email);
			return null;
		}
	}

	@Override
	@Transactional
	public List<User> getCustomer() {

		Session currSession = sessionFactory.getCurrentSession();

		Query<User> theQuery = currSession.createQuery("from User", User.class);

		List<User> theUser = theQuery.getResultList();
		System.out.println("Value of the customer admin" + theUser);
		return theUser;
	}

	/* if Designation is User the redirect to user Page */

	@Override
	@Transactional
	public List<User> getCustomerUser() {

		Session currSession = sessionFactory.getCurrentSession();

		Query<User> theQuery = currSession.createQuery("from User where designation='User'", User.class);

		List<User> theUser = theQuery.getResultList();
		System.out.println("Value of the customer: user  " + theUser);
		return theUser;
	}

	/* -=================================== */
	@Override
	public void editCustomer(User theUser) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public User updateUser(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		/*
		 * Query theQuery = currentSession.createQuery("from User where id=:theId",
		 * User.class);
		 * 
		 * theQuery.setParameter("theId", theId); System.out.println("User id" + theId);
		 * List<User> theUser = theQuery.getResultList();
		 * 
		 * System.out.println("user details for the given id " + theUser); return
		 * theUser;
		 */

		User theUser = currentSession.get(User.class, theId);
		return theUser;

	}

	@Override
	@Transactional
	public void UpdateSaveUser(User theUser) {

		Session currSession = sessionFactory.getCurrentSession();

		currSession.saveOrUpdate(theUser);

	}

	@Override
	@Transactional
	public void delteUser(int theId) {

		Session currenSession = sessionFactory.getCurrentSession();

		Query theQuery = currenSession.createQuery("delete from User where id=:CustomerId");

		theQuery.setParameter("CustomerId", theId);
		// User theUser = currenSession.get(User.class, theId);

		// currenSession.delete(theUser);
		theQuery.executeUpdate();

	}

	/*
	 * @Override public void editCustomer(User theUser) {
	 * 
	 * Session curreSession = sessionFactory.getCurrentSession();
	 * 
	 * }
	 */
}
