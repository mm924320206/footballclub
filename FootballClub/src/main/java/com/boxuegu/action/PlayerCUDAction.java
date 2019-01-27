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
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javassist.expr.NewArray;

@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("football")
public class PlayerCUDAction extends ActionSupport{
	/**
	 * 球员的增删改都是这个action
	 */
	//上传文件所需，提供set方法
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
	
	//注解开发
	@Autowired
	private IPlayerListModelService IPlayerListModelService;

	//为了html的select的候选项，专门从数据库查
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
	
	//添加球员，手动设置添加时间等，使用了级联保存，所以有个team的查询，最后时player。save（team）
	@Action(value = "playeradd", interceptorRefs = { @InterceptorRef("mystack") }, results = {
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
			//改照片名字
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSS");
			photoaddressFileName=sdf.format(new Date())+photoaddressFileName;
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
		  player.setCreatedate(new Date());
		  String teamString=ServletActionContext.getRequest().getParameter("select");
		  Team team=IPlayerListModelService.findTeamByName(teamString);
		  player.setPhotoaddress("/football/photos/"+destFile.getName());
		  //System.out.println(team.getName());
		  try {
			  IPlayerListModelService.save(player,team); 
				return "playlist";
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		
		}
		
		
	//仅仅是修改页面的默认输入值的获取
	@Action(value = "playerUpdate", interceptorRefs = { @InterceptorRef("mystack") }, results = {
			@Result(name = "error", location = "/login.jsp", type = "redirect"),
			@Result(name = "playeruppdate", location = "/page/playerUpdate.jsp"),
			@Result(name = "input", location = "/page/error.jsp") })
	public String playerUpdate ()
	{
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		String id=ServletActionContext.getRequest().getParameter("iid");
		Player player=IPlayerListModelService.findPlayerById(id);
		ActionContext.getContext().getValueStack().set("player", player);
		return "playeruppdate";
		
	}
	
	
	//修改页面重新获得数据，update入数据库，有事务管理
	@Action(value = "playerUpdateByid", interceptorRefs = { @InterceptorRef("mystack") }, results = {
			@Result(name = "error", location = "/login.jsp", type = "redirect"),
			@Result(name = "playlist", location = "/page/playerList.jsp", type = "redirect"),
			@Result(name = "input", location = "/page/error.jsp") })
	public String playerUpdateByid()
	
	{
		    try {
				ServletActionContext.getRequest().setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String path=ServletActionContext.getServletContext().getRealPath("/photos");
			//改名字
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSS");
			photoaddressFileName=sdf.format(new Date())+photoaddressFileName;
			File destFile=new File(path, photoaddressFileName);
			try {
				FileUtils.copyFile(photoaddress, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "input";
			}
			Player player=new Player();	
			String id=ServletActionContext.getRequest().getParameter("id"); 
		  player.setAge(Integer.parseInt(ServletActionContext.getRequest().getParameter("age")));
		  player.setName(ServletActionContext.getRequest().getParameter("name"));
		  player.setSalary(Double.parseDouble((ServletActionContext.getRequest().getParameter("salary"))));	  
		  player.setCreatedate(new Date());
		  String teamString=ServletActionContext.getRequest().getParameter("select");
		  Team team=IPlayerListModelService.findTeamByName(teamString);
		  player.setPhotoaddress("/football/photos/"+destFile.getName());
		  //System.out.println(team.getName());
		  try {
			  IPlayerListModelService.update(id,player,team); 
				
		} catch (Exception e) {
			// TODO: handle exception
			return "input";
		}
		  return "playlist";
		}
	
	
	//删除，也有事务管理
	@Action(value = "playerdelete", interceptorRefs = { @InterceptorRef("mystack") }, results = {
			@Result(name = "error", location = "/login.jsp", type = "redirect"),
			@Result(name = "playlist", location = "/page/playerList.jsp", type = "redirect"),
			@Result(name = "input", location = "/page/error.jsp") })
	public void playerDelete()
	
	{
			try {
				ServletActionContext.getRequest().setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String id=ServletActionContext.getRequest().getParameter("id"); 
		  
		  try {
			  IPlayerListModelService.playerDelete(id); 
			  ServletActionContext.getResponse().getWriter().write(1); 		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		  
		}
}
