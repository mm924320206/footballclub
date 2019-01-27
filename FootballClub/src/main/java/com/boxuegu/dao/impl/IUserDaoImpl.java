package com.boxuegu.dao.impl;

import java.util.List;

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

	/* 登陆查找数据库返回匹配 */
	@Override
	public User login(User user) {


		List<User> list = this.getHibernateTemplate().findByExample(user);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

}
