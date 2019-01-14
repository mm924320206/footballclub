package com.boxuegu.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
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
@Namespace("/")
@ParentPackage("struts-default")
public class LoginAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user=new User();
	@Autowired
	private IUserService userService;
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	@Action(value="user_login",
			results= {@Result(name="success",location="/page/main.jsp"),@Result(name="error",location="/login.jsp")})
	public String login()
	{
		User existUseruser=userService.login(user);
				if(existUseruser!=null)
				{
					ServletActionContext.getRequest().getSession().setAttribute("user", existUseruser);
					return "success";
				}
				else {
					return "error";
				}
		};
}
