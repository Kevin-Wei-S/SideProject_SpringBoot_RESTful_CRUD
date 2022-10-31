package com.kwei.springboot.controller;

import java.text.ParseException;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.kwei.springboot.dao.DepartmentDao;
import com.kwei.springboot.dao.EmployeeDao;
import com.kwei.springboot.entities.Department;
import com.kwei.springboot.entities.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	@GetMapping({"/", "/index.html"})
	public String index(HttpSession session) {
		Object loginUser = session.getAttribute("loginUser");
		if(loginUser != null) {
			return "redirect:/main.html";
		}
		return "index";
	}
	
	// 獲取所有員工訊息, 並返回列表頁面.
	@GetMapping("/emps")
	public String empList(Model model) {
		
		Collection<Employee> emps = employeeDao.getAllEmployees();
		model.addAttribute("emps", emps);
		// ThymeleafProperties會將返回值補上前後綴
		// classpath:/templates/{emp/list}.html
		return "emp/list";
		
	}
	
	@GetMapping("/emp")
	public String toAddPage(Model model) {
		
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("departments", departments);
		return "emp/add";
	}
	
	@PostMapping("/emp")
	public String addEmployee(Employee employee) throws ParseException {
		
		employeeDao.save(employee);
		// redirect: 重定向至目標網頁(兩次請求)
		// forward: 轉發至目標網頁(一次請求)
		// /: 當前項目路徑
		return "redirect:/emps";
		
	}

	@GetMapping("/emp/{id}")
	public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
		
		Employee emp = employeeDao.getEmployee(id);
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("emp", emp);
		model.addAttribute("departments", departments);
		
		return "emp/add";
	}
	
	@PutMapping("/emp")
	public String updateEmpById(Employee employee) {
		
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@DeleteMapping("/emp/{id}")
	public String deleteEmp(@PathVariable("id") Integer id) {
		employeeDao.deleteEmployee(id);
		return "redirect:/emps";
	}
	
}
