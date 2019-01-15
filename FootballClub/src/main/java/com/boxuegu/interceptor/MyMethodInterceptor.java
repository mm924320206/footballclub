package com.boxuegu.interceptor;

import org.apache.struts2.ServletActionContext;

import com.boxuegu.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyMethodInterceptor extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user!=null) {
			return invocation.invoke();
		}
		else {
			/* System.out.println("ssss");  测试是否加入成功*/
			return "error";
		}
	}
	
}
