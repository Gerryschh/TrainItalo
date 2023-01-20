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
		Collection<User> uu = new LinkedList <User>();
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select * from userr");
		List<Object[]> users = mq.list();

		for (Object[] o: users) {
			User u = new User();
			u.setUserMail((String) o[0]);
			u.setUserPassword((String) o[1]);
			u.setUserName((String) o[2]);
			u.setUserSurname((String) o[3]);
			u.setUserBirthdate((Date) o[4]);
			u.setAdmin((boolean) o[5]);
			u.setTrainGameScore((int) o[6]);
			
			uu.add(u);
		}
		return uu;
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
	
	@Override
	public User getUsernameAndScoreByMail(String userMail) {
		NativeQuery<Object []> mq = super.getSession().createSQLQuery("Select user_mail, user_name, train_game_score from userr where user_mail ='" + userMail + "'");

		List<Object[]> users = mq.list();
		if(users.size() > 0) {
			for (Object[] o: users) {
				User u = new User();
				u.setUserMail((String) o[0]);
				u.setUserName((String) o[1]);
				u.setTrainGameScore((Integer) o[2]);
				return u;
			}
		}
		return null;
	}
	
	@Override
	public void updateScoreWhenHigher(String userMail, int trainGameScore) {
		super.getSession().beginTransaction();
		User u = this.getSession().get(User.class, userMail);
		int oldScore = u.getTrainGameScore();
		
		if(trainGameScore > oldScore) {
			u.setTrainGameScore(trainGameScore);
			super.getSession().update(u);
			super.getSession().getTransaction().commit();
			super.getSession().close();
		}
	}

	@Override
	public void update(String userMail, String userName, String userSurname, Date userBirthdate) {
		super.getSession().beginTransaction();
		User u = this.getSession().get(User.class, userMail);
		u.setUserName(userName);
		u.setUserSurname(userSurname);
		u.setUserBirthdate(userBirthdate);
		super.getSession().update(u);
		super.getSession().getTransaction().commit();
	}
}
