package com.kwei.springboot.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PowerfulUtils {

	public static java.sql.Date dateStringToSqlDate(String strDate) throws ParseException {
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formater.parse(strDate);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		return sqlDate;
		
	}
	
}
