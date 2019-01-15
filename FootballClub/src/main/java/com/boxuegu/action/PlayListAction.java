package com.boxuegu.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boxuegu.domain.Player;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("football")
public class PlayListAction extends ActionSupport implements ModelDriven<Player>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player=new Player();
	@Override
	public Player getModel() {
		// TODO Auto-generated method stub
		return player;
	}
	
	@Action(value = "PlayList", interceptorRefs={@InterceptorRef("mystack")},results = { @Result(name = "success", location = "/page/playerList.jsp"),
			@Result(name = "error_playerlist", location = "/page/error.jsp",type="redirect"),@Result(name = "error", location = "/login.jsp",type="redirect") })
	public String playListByPage()
	{
		
		return "success";}
	}
