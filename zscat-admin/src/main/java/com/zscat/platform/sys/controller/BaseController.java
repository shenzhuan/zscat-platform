package com.zscat.platform.sys.controller;

import com.zscat.platform.sys.constant.AdminConstant;
import com.zscat.platform.sys.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 基础控制器类定义
 * @author yang.liu
 */
public abstract class BaseController {
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	protected static final String ERROR_PAGE = "/admin/page/servererror";
	protected static final String ERROR_MSG_KEY = "errMsg";
	
	/**
	 * 把返回给页面的信息设置到ModelMap中
	 * @param ob
	 * @param modelMap
	 */
	public static void settingParamsToModelMap(Object ob ,ModelMap modelMap){
		try {
			Field[] fields = ob.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}
				
				String fieldName = field.getName();
				Object fieldValue = field.get(ob);
				
				Field[] ofDeclaredFields = fieldValue.getClass().getDeclaredFields();
				// 该类如果为组合类型，那么把该类的成员中的字段也设置进去 只支持到类成员为pojo的情况
				if(ofDeclaredFields.length>=3){
					for (Field field2 : ofDeclaredFields) {
						field2.setAccessible(true);
						if (Modifier.isStatic(field2.getModifiers())) {
							continue;
						}
						String fieldName2 = field2.getName();
						Object fieldValue2 = field2.get(fieldValue);
						if(!modelMap.containsKey(fieldName2)){
							modelMap.put(fieldName2, fieldValue2);
						}else{
							Object object = modelMap.get(fieldName2);
							if(object==null||"".equals(object.toString().trim())){
								modelMap.put(fieldName2, fieldValue2);
							}
						}
					}
					continue;
				}
				
				modelMap.put(fieldName, fieldValue);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@ExceptionHandler(Throwable.class)
	public String handleException(Throwable e) {
		log.error("", e);
		return ERROR_PAGE;
	}


	public User getLoginUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(AdminConstant.USER_SESSION_KEY);
	}
	
	
	
}
