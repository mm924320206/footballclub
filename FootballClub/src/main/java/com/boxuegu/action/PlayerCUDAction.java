package com.boxuegu.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSONArray;
import com.boxuegu.domain.Player;
import com.boxuegu.domain.Team;
import com.boxuegu.service.IPlayerListModelService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("football")
public class PlayerCUDAction extends ActionSupport{
	/**
	 * 
	 */
	  private File photoaddress;
	  private String photoaddressContentType;
	  private String photoaddressFileName;
	  
	public File getPhotoaddress() {
		return photoaddress;
	}

	public void setPhotoaddress(File photoaddress) {
		this.photoaddress = photoaddress;
	}

	public String getPhotoaddressContentType() {
		return photoaddressContentType;
	}

	public void setPhotoaddressContentType(String photoaddressContentType) {
		this.photoaddressContentType = photoaddressContentType;
	}

	public String getPhotoaddressFileName() {
		return photoaddressFileName;
	}

	public void setPhotoaddressFileName(String photoaddressFileName) {
		this.photoaddressFileName = photoaddressFileName;
	}
	private static final long serialVersionUID = 1L;
	@Autowired
	private IPlayerListModelService IPlayerListModelService;

	@Action(value="selectShow",interceptorRefs = { @InterceptorRef("mystack") })
	  public void selectShow() {
	  ServletActionContext.getResponse().setCharacterEncoding("utf-8");
	 List<String> list =IPlayerListModelService.findTeam();  
	  String json= JSONArray.toJSONString(list); 
	  System.out.println(json); 
	  try {
	  ServletActionContext.getResponse().getWriter().write(json); 
	} 
	  catch(IOException e) 
	  {  e.printStackTrace(); 
	  }	 
}
	
	@Action(value = "player_add", interceptorRefs = { @InterceptorRef("mystack") }, results = {
			@Result(name = "error", location = "/login.jsp", type = "redirect"),
			@Result(name = "playlist", location = "/page/playerList.jsp", type = "redirect"),
			@Result(name = "input", location = "/page/error.jsp") })
	public String addPlayer()
	
	{
		    try {
				ServletActionContext.getRequest().setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String path=ServletActionContext.getServletContext().getRealPath("/photos");
			File destFile=new File(path, photoaddressFileName);
			try {
				FileUtils.copyFile(photoaddress, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "input";
			}
			Player player=new Player();	
		  player.setAge(Integer.parseInt(ServletActionContext.getRequest().getParameter("age")));
		  player.setName(ServletActionContext.getRequest().getParameter("name"));
		  player.setSalary(Double.parseDouble((ServletActionContext.getRequest().getParameter("salary"))));
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 */		  
		  player.setCreatedate(new Date());
		  String teamString=ServletActionContext.getRequest().getParameter("select");
		  Team team=IPlayerListModelService.findTeamByName(teamString);
		  player.setPhotoaddress(destFile.getPath());
		  System.out.println(team.getName());
		  IPlayerListModelService.save(player,team); 
		  
		/*
		 * System.out.println(player.getCreatedate()); System.out.println(team.getId());
		 * System.out.println(player.getPhotoaddress());
		 * System.out.println(player.getAge()); System.out.println(player.getName());
		 */
		  
		 
			
		
		/* Boolean tBoolean=IPlayerListModelService.addplayer(); */
		Boolean tBoolean=true;
		if (tBoolean) {
			return "playlist";
		}
		else {
			return "input";
		}
		}
}
