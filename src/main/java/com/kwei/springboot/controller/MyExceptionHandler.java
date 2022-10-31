package com.kwei.springboot.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kwei.springboot.exception.UserNotExistException;

@ControllerAdvice
public class MyExceptionHandler{

	// 1. 瀏覽器與客戶端返回的都是Json數據
//	@ResponseBody
//	@ExceptionHandler(UserNotExistException.class)
//	public Map<String,Object> handleException(Exception e) {
//		Map<String,Object> map = new HashMap<>();
//		map.put("code", "user.notexist");
//		map.put("message", e.getMessage());
//		
//		return map;
//	}

	
	// 2. 轉發到 /error 進入訂製頁面解析流程
//	@ExceptionHandler(UserNotExistException.class)
//	public String handleException(Exception e, Model model, HttpServletRequest req) {
//		//傳入錯誤代碼 進入訂製頁面解析流程
//		req.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, 500);
//		model.addAttribute("code", "user.notexist");
//		model.addAttribute("msg", "GJJ!");
//		return "forward:/error";
//	}
	
	// 3. 轉發到 /error 且挾帶自定義屬性進入訂製頁面解析流程
	@ExceptionHandler(UserNotExistException.class)
	public String handleException(Exception e, HttpServletRequest req) {
		// /error訂製頁面解析會根據RequestDispatcher.ERROR_STATUS_CODE獲取StatusCode
		req.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, 500);
		Map<String,Object> map = new HashMap<>();
		map.put("code", "user.notexist");
		map.put("msg", "GJJ!");
		req.setAttribute("extension", map);
		return "forward:/error";
	}
	
}
