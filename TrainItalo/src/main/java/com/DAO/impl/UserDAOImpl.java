package com.DAO.impl;

import com.beans.User;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.query.NativeQuery;

import com.DAO.UserDAO;

public class UserDAOImpl extends BaseDAO implements UserDAO {

	public void create(User u) {
		super.create(u);
	}

	@Override
	public User get(String userMail) {
		return (User) super.get(User.class, userMail);
	}

	@Override
	public Collection<User> getAllNormal() {
		Collection<User> cu = new LinkedList <User>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from userr where is_admin = 0");
		List<Object[]> users = mq.list();

		for (Object[] o: users) {
			User u = new User();
			u.setUserMail((String) o[0]);
			u.setUserPassword((String) o[1]);
			u.setUserName((String) o[2]);
			u.setUserSurname((String) o[3]);
			u.setAdmin((Boolean) o[4]);
			u.setTrainGameScore((Integer) o[5]);
			cu.add(u);
		}
		return cu;
	}

	@Override
	public Collection<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getAllAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByMailAndPsw(String userMail, String userPassword) {
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from userr where user_mail ='" + userMail + "' and user_password = '" +  userPassword + "'");

		List<Object[]> users = mq.list();
		if(users.size() > 0) {
			for (Object[] o: users) {
				User u = new User();
				u.setUserMail((String) o[0]);
				u.setUserPassword((String) o[1]);
				u.setUserName((String) o[2]);
				u.setUserSurname((String) o[3]);
				u.setUserBirthdate((Date) o[4]);
				u.setAdmin((Boolean) o[5]);
				u.setTrainGameScore((Integer) o[6]);
				return u;
			}
		}
		return null;
	}
}
