package com.kwei.springboot.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwei.springboot.entities.Department;
import com.kwei.springboot.entities.Employee;

@Repository
public class EmployeeDao {

	private static Map<Integer,Employee> employees = new LinkedHashMap<>();
	@Autowired
	private DepartmentDao departmentDao;
	
	static {
		employees.put(1001, new Employee(1001, "Wei", "Wei@gmail.com"
				, 1, new Department(404, "Research-And-Development")
				, Date.valueOf(LocalDate.of(1995,10,20))));
		employees.put(2002, new Employee(2002, "Cruise", "Cruise@gmail.com"
				, 1, new Department(202, "Public-Relations")
				, Date.valueOf(LocalDate.of(1990,5,20))));
		employees.put(3003, new Employee(3003, "Kidman", "Kidman@gmail.com"
				, 0, new Department(101, "Human-Resources")
				, Date.valueOf(LocalDate.of(1982,7,25))));
		employees.put(4004, new Employee(4004, "Amber", "Amber@gmail.com"
				, 0, new Department(303, "Information-Technology")
				, Date.valueOf(LocalDate.of(1970,3,20))));
		employees.put(5005, new Employee(5005, "Depp", "Depp@gmail.com"
				, 1, new Department(404, "Research-And-Development")
				, Date.valueOf(LocalDate.of(1975,12,12))));
		employees.put(6006, new Employee(6006, "Kate", "Kate@gmail.com"
				, 0, new Department(505, "Marketing")
				, Date.valueOf(LocalDate.of(1987,2,14))));
		employees.put(7007, new Employee(7007, "William", "William@gmail.com"
				, 1, new Department(606, "Customer-Service")
				, Date.valueOf(LocalDate.of(1977,1,31))));
	}
	
	private static Integer initId = 8008;
	
	// 新增或更新
	public void save(Employee employee) {
		if(employee.getId() == null) {
			employee.setId(initId);
			initId += 1001;
		}
		// 根據DepartmentId補足DepartmentName
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	// 獲取所有員工列表
	public Collection<Employee> getAllEmployees(){
		return employees.values();
	}
	
	// 根據id獲取員工資訊
	public Employee getEmployee(Integer id) {
		return employees.get(id);
	}
	
	// 根據id移除員工訊息
	public void deleteEmployee(Integer id) {
		employees.remove(id);
	}
	
}
