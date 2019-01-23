package com.boxuegu.dao;

import java.util.List;

import com.boxuegu.domain.Player;
import com.boxuegu.domain.Team;

public interface IPlayerListModelDao {

	int finTotalCount();

	List<Player> findByPage(int pageNum, int currentCount);

	List<String> findTeam();

	void save(Player player, Team team);

	Team findTeamByName(String teamString);

	Player findTeamById(String id);

	void update(String id, Player player, Team team);

	void playerDelete(String id);

}
