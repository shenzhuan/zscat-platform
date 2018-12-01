package com.zscat.platform.sys.model;

import java.io.Serializable;

/**
 * 子菜单实体类定义
 * @author yang.liu
 */
public class SubMenu implements Serializable{

	private static final long serialVersionUID = 869358248026592993L;

	private long menuId;
	private long subMenuId;
	private String subMenuName;
	private String url;

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public long getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(long subMenuId) {
		this.subMenuId = subMenuId;
	}

	public String getSubMenuName() {
		return subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
