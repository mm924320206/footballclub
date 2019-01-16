package com.boxuegu.dao;

import java.util.List;

import com.boxuegu.domain.Player;

public interface IPlayerListModelDao {

	int finTotalCount();

	List<Player> findByPage(int pageNum, int currentCount);

}
