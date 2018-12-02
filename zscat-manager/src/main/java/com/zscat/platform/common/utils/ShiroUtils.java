package com.zscat.platform.common.utils;

import com.zscat.platform.system.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {
	public static Subject getSubjct() {
		return SecurityUtils.getSubject();
	}
	public static UserDO getUser() {
		return (UserDO)getSubjct().getPrincipal();
	}
	public static Long getUserId() {
		if (getUser()!=null){
			return getUser().getUserId();
		}
		return null;
	}
	public static void logout() {
		getSubjct().logout();
	}
}
