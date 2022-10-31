package com.kwei.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kwei.springboot.exception.UserNotExistException;

@Controller
public class GreetController {

	// 處理登入且規避重複提交
	// @RequestMapping(value="/user/login", method=RequestMethod.POST)
	@PostMapping("/user/login")
	public String login(String username, String password, Map<String, Object> map, HttpSession session) {
		// 登入後, 為防止表單重複提交, 故採用重定向到目標網頁.
		if ("admin".equals(username) && "root".equals(password)) {
			session.setAttribute("loginUser", username);
			return "redirect:/main.html";
		}
		// 登入不成功, 提示訊息.
		map.put("msg", "Username or password is not correct!");
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	public String greet() {
		return "Amitofo";
	}

	@RequestMapping("/success")
	public String toSuccess(Map<String, Object> map) {
		map.put("username", "<h1>Cruise</h1>");
		map.put("users", List.of("Tom", "Cruise", "Nicole", "Kidman"));
		return "success";
	}

	@ResponseBody
	@GetMapping("/hello")
	public String hello(String username, Model model) {

		if ("login".equals(username)) {
			return "success";
		}
		
		throw new UserNotExistException();

	}

//	@RequestMapping({"/", "/index.html"})
//	public String index() {
//		return "index";
//	}

}
