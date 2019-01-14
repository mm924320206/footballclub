package com.boxuegu.domain;

/**
 * 球员实体
 * 
 * @author Administrator
 *
 */
public class Player {
	private String id;// 设置uuid 球员ID
	private String name;// 球员姓名
	private int age;// 球员年龄
	private double salary;
	private Team team;// 所属球队
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
}
