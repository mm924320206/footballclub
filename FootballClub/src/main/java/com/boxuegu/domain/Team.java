package com.boxuegu.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 球队实体
 * 
 * @author Administrator
 *
 */
public class Team {
	private Integer id;// 球队ID
	private String name;// 球队名称
	private Set<Player> players = new HashSet<Player>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
}
