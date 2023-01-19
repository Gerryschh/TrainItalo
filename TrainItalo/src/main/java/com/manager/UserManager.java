package com.manager;

import java.util.Collection;
import java.util.Date;

import com.DAO.UserDAO;
import com.DAO.impl.UserDAOImpl;
import com.beans.User;

public class UserManager {
	UserDAO userDAO = new UserDAOImpl();
	
	public void addUser(User u) {
		userDAO.create(u);
	}
	
	public User getUser(String userMail) {
		return userDAO.get(userMail);
	}
	
	public Collection<User> getAllUsers() {
		return userDAO.getAll();
	}
	
	public User getUserByMailAndPsw(String userEmail, String userPassword) {
		return userDAO.getByMailAndPsw(userEmail, userPassword);
	}
	
	public void updateUser(String userMail, String userName, String userSurname, Date userBirthdate) {
		userDAO.update(userMail, userName, userSurname, userBirthdate);
	}
}
