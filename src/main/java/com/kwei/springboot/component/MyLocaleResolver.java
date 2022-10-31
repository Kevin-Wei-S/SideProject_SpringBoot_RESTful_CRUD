package com.kwei.springboot.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/**
 *  區域解析器:
 *  	1. 獲取客戶端請求
 *  	2. 使用自定義區域解析器進行解析
 *  	3. 檢查是否帶有語言及國家參數
 *  	4. 如果沒有, 採用默認區域進行解析.
 *  	5. 如果有, 則根據請求參數進行解析
 * @author a8566
 *
 */
public class MyLocaleResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String l = request.getParameter("l");
		Locale locale = null;
		if(!StringUtils.isEmpty(l)) {
			String[] splits = l.split("_");
			locale = new Locale(splits[0], splits[1]);
		} else {
			String[] split = request.getHeaders("Accept-Language").nextElement().split(",");
			String[] splits = split[0].split("-");
			locale = new Locale(splits[0], splits[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		
	}

	
}
