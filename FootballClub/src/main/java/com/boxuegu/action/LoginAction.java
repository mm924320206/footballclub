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
@Namespace("/")
@ParentPackage("football")
public class LoginAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	@Autowired
	private IUserService userService;

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	@Action(value = "user_login", interceptorRefs={@InterceptorRef("mystack")},results = { @Result(name = "success", location = "/page/main.jsp",type="redirect"),
			@Result(name = "error", location = "/login.jsp") })
	public String login() {
		User existUseruser = userService.login(user);
		if (existUseruser != null) {
			ServletActionContext.getRequest().getSession().setAttribute("user", existUseruser);
			//添加cookie，方便过滤器拦截非用户访问其他页面
			Cookie cookie=new Cookie("user", existUseruser.getUsername()+"###"+existUseruser.getPassword());
			cookie.setPath("/footballClub");
			//设置cook有效时间10分钟
			cookie.setMaxAge(60*10);
			ServletActionContext.getResponse().addCookie(cookie);

			return "success";
		} else {
			this.addActionError("用户名或密码错误！");
			return "error";
		}
	};
}
