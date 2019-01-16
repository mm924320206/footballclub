package com.boxuegu.service;

import com.boxuegu.domain.PageBean;
import com.boxuegu.domain.Player;

public interface IPlayerListModelService {

	PageBean<Player> showPlayerList(int pageNum, int currentCount);

}
