package com.boxuegu.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.boxuegu.dao.IUserDao;
import com.boxuegu.domain.User;

@Repository("userDao")
public class IUserDaoImpl extends HibernateDaoSupport implements IUserDao {
	@Autowired
	@Qualifier("sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public User login(User user) {
		
		/*
		 * return (User)this.getHibernateTemplate().
		 * findByNamedParam("from User u where u.username=? and u.password=?",
		 * user.getUsername(), user.getPassword());
		 */
		User user2=new User();
		user2.setUsername("admin");
		user2.setPassword("admin");
		user2.setId(1);
		return user2;
		 
	}

}
