package com.kwei.springboot;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kwei.springboot.dao.EmployeeDao;

@SpringBootTest
class SpringBoot04WebRestfulCrudApplicationTests {

	@Autowired
	private EmployeeDao empDao;
	
	@Test
	void contextLoads() {
		String l = "en_US";
		String language = l.split("_")[0];
		String region = l.split("_")[1];
		
		System.out.println("Language: " + language + ", Region: " + region);
	}
	
	@Test
	void testDate() throws ParseException {
		
//		Date date = new Date();
//		System.out.println(date);
//		LocalDate localDate = LocalDate.of(1995, 10, 20);
//		Date date = Date.valueOf(localDate);
//		System.out.println(date);
		
//		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = formater.parse("2022-9-22");
//		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//		System.out.println(sqlDate);
		
//		Date date = PowerfulUtils.dateStringToSqlDate("2022-9-22");
//		System.out.println(date);
		
	}
	
	@Test
	void testEmpDao() {
		
		empDao.getAllEmployees().forEach(System.out::println);		
		empDao.deleteEmployee(1001);
		System.out.println("------------------------------------");
		empDao.getAllEmployees().forEach(System.out::println);		
	}

}
