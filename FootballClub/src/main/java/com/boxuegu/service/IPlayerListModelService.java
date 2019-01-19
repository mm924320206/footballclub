package com.boxuegu.service;

import java.util.List;

import com.boxuegu.domain.PageBean;
import com.boxuegu.domain.Player;
import com.boxuegu.domain.Team;

public interface IPlayerListModelService {

	PageBean<Player> showPlayerList(int pageNum, int currentCount);

	List<String> findTeam();

	void save(Player player, Team team);

	Team findTeamByName(String teamString);

}
