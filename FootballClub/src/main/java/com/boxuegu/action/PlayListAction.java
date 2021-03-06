package com.boxuegu.action;

import java.io.IOException;

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
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.boxuegu.domain.PageBean;
import com.boxuegu.domain.Player;
import com.boxuegu.service.IPlayerListModelService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("football")
public class PlayListAction extends ActionSupport implements ModelDriven<PageBean<Player>>{


	/**
	 * 分页显示，返回json
	 */
	private static final long serialVersionUID = 1L;
	private PageBean<Player> pageBean=new PageBean<Player>();
	@Override
	public PageBean<Player> getModel() {
		// TODO Auto-generated method stub
		return pageBean;
	}
	@Autowired
	private IPlayerListModelService IPlayerListModelService;
	@Action(value = "PlayList", interceptorRefs={@InterceptorRef("mystack")},results = { @Result(name = "error", location = "/login.jsp",type="redirect")})
	public void playListByPage()
	{
		/**
		 * var pageNum=1;
	var totalPage=0;
	var totalCount=0;
	var currentCount=5;
	alert("ssa");
		$.post("/football/PlayList", {
		"pageNum" : pageNum,
		"totalPage" : totalPage,
		"totalCount" : totalCount,
		"currentCount":currentCount
		 */
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		int pageNum=Integer.parseInt((ServletActionContext.getRequest().getParameter("pageNum")));
		int currentCount=Integer.parseInt((ServletActionContext.getRequest().getParameter("currentCount")));
		/* System.out.println(pageNum); */
		PageBean<Player> pageBean=IPlayerListModelService.showPlayerList(pageNum,currentCount);
		
		  PropertyFilter filter=new PropertyFilter() {
		  
			  //json数据串，不要players的部分
		  @Override 
		  public boolean apply(Object object, String name, Object value) {
				/*
				 * if ("id".equalsIgnoreCase(name)) { return false; }
				 */
		  if ("players".equalsIgnoreCase(name)) {
			  return false; 
		}
				/*
				 * if ("team".equalsIgnoreCase(name)) { return false; }
				 */
		
		  return true; } };
		 
		String json=JSONArray.toJSONString(pageBean,filter,SerializerFeature.DisableCircularReferenceDetect);
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
		}
	}
