package com.boxuegu.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boxuegu.dao.IPlayerListModelDao;
import com.boxuegu.domain.Player;
import com.boxuegu.domain.Team;
import com.boxuegu.domain.User;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> findByPage(int pageNum, int currentCount) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Player.class);
		detachedCriteria.addOrder(Order.desc("createdate"));
		return (List<Player>) this.getHibernateTemplate().findByCriteria(detachedCriteria, (pageNum - 1) * currentCount,
				currentCount);
	}

	@Override
	public List<String> findTeam() {
		// TODO Auto-generated method stub
		List<String> list = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery("select name from t_team").list();
		System.out.println(list);
		if (list.size() > 0) {
			return list;
		} else {
			System.out.println("111");
			return null;
		}
	}

	

	@Override
	public Team findTeamByName(String teamString) {
		/*
		 * String hqlString="from Team t where t.name=:myName"; String paramName=
		 * "myName"; String value= teamString; List<Object>
		 * list=(List<Object>)getHibernateTemplate().findByNamedParam(hqlString,
		 * paramName, value);
		 */
		List<Object> list=(List<Object>)getHibernateTemplate().find("from Team where name=?",teamString);
		System.out.println(list);
		return (Team) list.get(0);
	}
	@Transactional
	@Override
	public void save(Player player, Team team) {
		player.setTeam(team);
		team.getPlayers().add(player);
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(player);
		
	}

	@Override
	public Player findTeamById(String id) {
		@SuppressWarnings("unchecked")
		List<Object> list=(List<Object>)getHibernateTemplate().find("from Player where id=?",id);
		if (list.size() > 0) {
			return (Player) list.get(0);
		} else {		
			return null;
		}
		
	}
	@Transactional
	@Override
	public void update(String id,Player player,Team team) {
		List<Player> list=(List<Player>)getHibernateTemplate().find("from Player where id=?",id);
		if (list.size() > 0) 
		{
			player.setId(id);
			player.setTeam(team);
			
		this.getHibernateTemplate().merge(player);
	}
	}

	@Override
	public void playerDelete(String id) {
		List<Player> list=(List<Player>)getHibernateTemplate().find("from Player where id=?",id);
		if (list.size() > 0) 
		{	
		this.getHibernateTemplate().delete(list.get(0));
	}
		
	}

}
