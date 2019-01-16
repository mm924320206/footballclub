package com.boxuegu.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 球队实体
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name="t_team",catalog="footballclub")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;// 球队ID
	private String name;// 球队名称
	@OneToMany(targetEntity=Player.class,mappedBy="team",cascade=CascadeType.ALL)
	private Set<Player> players = new HashSet<Player>();
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", players=" + players + "]";
	}
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
