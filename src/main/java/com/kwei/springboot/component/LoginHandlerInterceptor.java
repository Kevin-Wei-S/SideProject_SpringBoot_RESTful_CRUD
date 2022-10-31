package com.kwei.springboot.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 	登入檢查
 * @author a8566
 *
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

	// 目標方法執行之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Object loginUser = request.getSession().getAttribute("loginUser");
		if(loginUser == null) {
			// 未登入, 返回登入頁面.
			request.setAttribute("msg", "請先登入會員");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		} else {
			// 已登入, 放行請求.
			return true;
		}
			
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	
	
}
