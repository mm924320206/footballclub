package com.boxuegu.action;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boxuegu.domain.User;
import com.boxuegu.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@Namespace("/page")
@ParentPackage("football")
public class NullAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* 纯粹是防止地址栏在输入/football/page/时显示错误，手动跳转到欢迎页 */
	@Action(value = "", interceptorRefs={@InterceptorRef("mystack")},results = { @Result(name = "success", location = "/page/main.jsp",type="redirect"),
			@Result(name = "error", location = "/login.jsp") })
	public String Nullcc() {
		if (ServletActionContext.getRequest().getSession().getAttribute("user")!=null) {
			return "success";
		} else {
return "error";
		}
			
	};
}
