package com.zscat.platform.sys.dao;

import com.zscat.platform.sys.model.Role;

import java.util.List;

/**
 * 角色Dao接口定义
 * @author yang.liu
 *
 */
public interface RoleDao {

	/**
	 * 根据用户ID获取角色列表
	 * @param userId 用户ID
	 * @return
	 */
	public List<Role> queryByUserId(long userId);
}
