package com.boxuegu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.boxuegu.dao.IPlayerListModelDao;
import com.boxuegu.domain.Player;
import com.boxuegu.domain.Team;


@Repository("PlayerListModelDao")
public class IPlayerListModelDaoImpl extends HibernateDaoSupport implements IPlayerListModelDao {

	@Autowired
	@Qualifier("sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/* 为了分页显示，返回球员总数 */
	@Override
	public int finTotalCount() {
		return ((Long) this.getHibernateTemplate().find("select count(*) from Player").iterator().next()).intValue();
	}

	/* 分页显示 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> findByPage(int pageNum, int currentCount) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Player.class);
		detachedCriteria.addOrder(Order.desc("createdate"));
		return (List<Player>) this.getHibernateTemplate().findByCriteria(detachedCriteria, (pageNum - 1) * currentCount,
				currentCount);
	}

	/* 在新增和修改球员页面，有个select，为那个部件返回候选项 */
	@Override
	public List<String> findTeam() {
		// TODO Auto-generated method stub
		List<String> list = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery("select name from t_team").list();
		System.out.println(list);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	
	/* 因为是在新增的时候是级联保存，有个player.setTeam(team)操作，所以这步根据name先返回一个team对象 */
	@Override
	public Team findTeamByName(String teamString) {

		List<Object> list=(List<Object>)getHibernateTemplate().find("from Team where name=?",teamString);
		System.out.println(list);
		return (Team) list.get(0);
	}

	/* 新增球员保存 */
	@Override
	public void save(Player player, Team team) {
		player.setTeam(team);
		team.getPlayers().add(player);
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(player);
		
	}

	/* 在点击进入更新球员界面时，从数据库拉取被选择的候选项，默认填入input内 */
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

	/* 级联更新，用得merge，避免三态问题 */
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

	/* 删除 */
	@Override
	public void playerDelete(String id) {
		List<Player> list=(List<Player>)getHibernateTemplate().find("from Player where id=?",id);
		if (list.size() > 0) 
		{	
		this.getHibernateTemplate().delete(list.get(0));
	}
		
	}

}
