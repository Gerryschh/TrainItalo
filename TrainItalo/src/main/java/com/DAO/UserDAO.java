package com.DAO;

import java.util.Collection;

import com.beans.User;

public interface UserDAO {
	
	public void create(User u);
	public User get(String userMail);
	public Collection<User> getAll(); //Get all users
	public Collection<User> getAllNormal(); //Get users that haven't got admin powers
	public Collection<User> getAllAdmin(); //Get users that have got admin powers
	public User getByMailAndPsw(String userMail, String userPassword); //Get user by mail and password
	
}
