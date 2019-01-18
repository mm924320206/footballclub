package com.boxuegu.action;

import java.io.File;
import java.io.IOException;

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

import com.boxuegu.domain.Player;
import com.boxuegu.service.IPlayerListModelService;
import com.boxuegu.utils.UpLoadFilesAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("football")
public class PlayerCUDAction extends ActionSupport/* implements ModelDriven<Player> */{
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
	/*
	 * private Player player=new Player();
	 * 
	 * @Override public Player getModel() { // TODO Auto-generated method stub
	 * return player; }
	 */
	@Autowired
	private IPlayerListModelService IPlayerListModelService;

	@Action(value = "player_add", interceptorRefs = { @InterceptorRef("mystack") }, results = {
			@Result(name = "error", location = "/login.jsp", type = "redirect"),
			@Result(name = "playlist", location = "/page/playerList.jsp", type = "redirect"),
			@Result(name = "input", location = "/page/error.jsp") })
	public String addPlayer()
	{
		
		System.out.println("fileName:"+this.getPhotoaddressFileName());
        System.out.println("contentType:"+this.getPhotoaddressContentType());
        System.out.println("File:"+this.getPhotoaddress());
			String path=ServletActionContext.getServletContext().getRealPath("/photos");
			File destFile=new File(path, photoaddressFileName);
			try {
				FileUtils.copyFile(photoaddress, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "input";
			}
			
		
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
