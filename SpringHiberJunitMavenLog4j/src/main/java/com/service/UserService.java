package com.service;

import java.util.List;

import com.customexception.UserNotFoundException;
import com.model.User;

public interface UserService {
	/**
	 * Retrieves all Users
	 * 
	 * @return a list of Users
	 */
	public List<User> getAll();

	/**
	 * Retrieves a single User
	 */
	public User get(Integer id);

	/**
	 * Adds a new User
	 */
	public void add(User User);

	/**
	 * Deletes an existing User
	 * 
	 * @param id
	 *            the id of the existing User
	 * @throws UserNotFoundException 
	 */
	public void delete(Integer id) throws UserNotFoundException;

	/**
	 * Edits an existing User
	 * @throws UserNotFoundException 
	 */
	public void edit(User User) throws UserNotFoundException;

}
