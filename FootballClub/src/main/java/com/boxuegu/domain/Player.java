package com.boxuegu.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 球员实体
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name="t_player",catalog="footballclub")
public class Player {
	@Id
	@GenericGenerator(name="myuuid",strategy="uuid")
	@GeneratedValue(generator="myuuid")
	private String id;// 设置uuid 球员ID
	@Override
	public String toString() {
		return "Player [id=" + id + ", photoaddress=" + photoaddress + ", name=" + name + ", age=" + age + ", salary="
				+ salary + ", createdate=" + createdate + ", team=" + team + "]";
	}
	private String photoaddress; //照片地址
	private String name;// 球员姓名
	private int age;// 球员年龄
	private double salary;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate; //创建日期
	@ManyToOne(targetEntity=Team.class)
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
