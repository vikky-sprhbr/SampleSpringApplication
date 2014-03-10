package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.customexception.UserNotFoundException;
import com.model.User;

@Repository
// mark as a DAO, Spring will identify as DAO
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	// create a getCurrentSession() to short in length of statements in caller
	// methods
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession(); // Get current session and
													// return it
	}

	/**
	 * Retrieves all Users
	 * 
	 * @return a list of Users
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		logger.debug("Retrieving all Users");

		// Create a Hibernate query (HQL)
		org.hibernate.Query query = getCurrentSession().createQuery(
				"FROM  User");

		// Retrieve all
		return query.list();
	}

	/**
	 * Retrieves a single User
	 */
	public User get(Integer id) {
		// Retrieve existing User first
		User user = (User) getCurrentSession().get(User.class, id);

		return user;
	}

	/**
	 * Adds a new User
	 */
	public void add(User User) {
		logger.debug("Adding new User");

		// Save
		getCurrentSession().save(User);
	}

	/**
	 * Deletes an existing User
	 * 
	 * @param id
	 *            the id of the existing User
	 */
	public void delete(Integer id) throws UserNotFoundException {
		logger.debug("Deleting existing User");

		// Retrieve existing User first
		User User = (User) getCurrentSession().get(User.class, id);

		if (User == null)
			throw new UserNotFoundException("user not found");

		// Delete
		getCurrentSession().delete(User);
	}

	/**
	 * Edits an existing User
	 */
	public void edit(User User) throws UserNotFoundException {
		logger.debug("Editing existing User");

		// Retrieve existing User via id
		User existingUser = (User) getCurrentSession().get(User.class,
				User.getUserId());

		if (existingUser == null)
			throw new UserNotFoundException("user not found");

		// Assign updated values to this User
		existingUser.setFirstName(User.getFirstName());
		existingUser.setLastName(User.getLastName());

		// Save updates
		getCurrentSession().update(existingUser); // call update method not save

	}
}
