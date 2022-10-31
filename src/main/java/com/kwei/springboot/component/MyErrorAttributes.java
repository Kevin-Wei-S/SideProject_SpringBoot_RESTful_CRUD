package com.kwei.springboot.component;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

// 將自定義錯誤屬性加入容器中 
// 訂製解析頁面在有自定義ErrorAttributes組件時 會使用自定義組件
// 否則應用DefaultErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		Map<String,Object> map = super.getErrorAttributes(webRequest, options);
		map.put("Amitofo", "K-Wei");
		map.put("Life", "Tranquil");
		// 異常處理器挾帶的屬性
		Map<String,Object> extension = (Map<String,Object>)webRequest.getAttribute("extension", RequestAttributes.SCOPE_REQUEST);
		map.put("extension", extension);
		
		return map;
	}
	
	
}
