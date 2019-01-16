package com.boxuegu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boxuegu.dao.IPlayerListModelDao;
import com.boxuegu.domain.PageBean;
import com.boxuegu.domain.Player;
import com.boxuegu.service.IPlayerListModelService;
@Service("IPlayerListModelService")
public class IPlayerListModelServiceImpl implements IPlayerListModelService {
	@Autowired
	@Qualifier("PlayerListModelDao")
	private IPlayerListModelDao PlayerListModelDao;
	@Override
	public PageBean<Player> showPlayerList(int pageNum, int currentCount) {
		// TODO Auto-generated method stub
		PageBean<Player> pageBean=new PageBean<Player>();
		//每页条数
		pageBean.setCurrentCount(currentCount);
		//当前页码
		pageBean.setPageNum(pageNum);
		//返回总记录数
		int totalCount=PlayerListModelDao.finTotalCount();
		pageBean.setTotalCount(totalCount);
		//根据总记录和每页条数，设置多少页
		int totalPage=(int) Math.ceil(totalCount*1.0/currentCount);
		//返回查询的每页的球员
		List<Player> players=PlayerListModelDao.findByPage(pageNum,currentCount);
		pageBean.setCurrentCounts(players);
		return pageBean;
	}

}