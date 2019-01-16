package com.boxuegu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.boxuegu.dao.IPlayerListModelDao;
import com.boxuegu.domain.Player;
@Repository("PlayerListModelDao")
public class IPlayerListModelDaoImpl extends HibernateDaoSupport implements IPlayerListModelDao {

	@Autowired
	@Qualifier("sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public int finTotalCount() {
		return ((Long) this.getHibernateTemplate().find("select count(*) from Player").iterator().next()).intValue();
	}
	@Override
	public List<Player> findByPage(int pageNum, int currentCount) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Player.class);
		return (List<Player>) this.getHibernateTemplate().findByCriteria(detachedCriteria, (pageNum-1)*currentCount, currentCount);
	}

}
