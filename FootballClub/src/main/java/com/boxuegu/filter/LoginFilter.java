package com.boxuegu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boxuegu.domain.User;
import com.boxuegu.utils.CookieUtils;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("user");
		//解决第一次过滤死循环..
		// 获得请求的URL
				String url = req.getRequestURL().toString();
/*				/ 使用endsWith()判断url结尾的字符串*/
				if (url.endsWith("login.jsp") || user != null
					 || url.endsWith(".css") || url.endsWith(".js") 
					 || url.endsWith(".gif")|| url.endsWith(".png") 
					 || url.endsWith(".jpg")|| url.endsWith("bmp")
					 ||url.endsWith("index.jsp")
					 )
				{chain.doFilter(request, response);}			
/*		作者：我愿不老丶 
		来源：CSDN 
		原文：https://blog.csdn.net/qq_34719291/article/details/73181403 
		版权声明：本文为博主原创文章，转载请附上博文链接！*/

		else {
			
			
			httpServletResponse.sendRedirect(req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/login.jsp");
				
				
				}
			
			}



	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
