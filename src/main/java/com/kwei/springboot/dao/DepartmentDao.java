package com.kwei.springboot.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kwei.springboot.entities.Department;

@Repository
public class DepartmentDao {

	private static Map<Integer,Department> departments = new LinkedHashMap<>();
	
	static {
		departments.put(101, new Department(101, "Human-Resources"));
		departments.put(202, new Department(202, "Public-Relations"));
		departments.put(303, new Department(303, "Information-Technology"));
		departments.put(404, new Department(404, "Research-And-Development"));
		departments.put(505, new Department(505, "Marketing"));
		departments.put(606, new Department(606, "Customer-Service"));
	}
	
	// 獲取所有部門訊息
	public Collection<Department> getDepartments() {
		return departments.values();
	}
	
	// 根據id獲取部門訊息
	public Department getDepartment(Integer id) {
		return departments.get(id);
	}
	
}
