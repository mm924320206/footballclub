package com.boxuegu.utils;

import javax.servlet.http.Cookie;

/*没用上，原本是为了方便获得cookie，从而自动登陆等*/
public class CookieUtils {

	public static Cookie findCookie(Cookie[] cookies,String name){
		if(cookies == null){
			return null;
		}else{
			for(Cookie cookie:cookies){
				if(name.equals(cookie.getName())){
					return cookie;
				}
			}
			
			return null;
		}
	}
}
