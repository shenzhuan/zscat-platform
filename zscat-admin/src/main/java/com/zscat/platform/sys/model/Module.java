package com.zscat.platform.sys.model;

import java.io.Serializable;

/**
 * 模块实体类定义
 * @author yang.liu
 */
public class Module implements Serializable {

	private static final long serialVersionUID = 6892464920250970605L;

	private long moduleId;
	private String moduleName;
	private int isMenu;
	private int showOrder;
	private int status;

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(int isMenu) {
		this.isMenu = isMenu;
	}

	public int getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(int showOrder) {
		this.showOrder = showOrder;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
