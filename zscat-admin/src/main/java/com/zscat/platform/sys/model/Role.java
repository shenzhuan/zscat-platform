package com.zscat.platform.sys.model;

import java.io.Serializable;

/**
 * 角色实体类定义
 * @author yang.liu
 */
public class Role implements Serializable {

	private static final long serialVersionUID = -8499199070718416867L;

	private long roleId;
	
	private String roleName;
	
	private int isAdmin;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

}
