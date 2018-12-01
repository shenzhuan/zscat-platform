package com.zscat.platform.sys.model;

import java.io.Serializable;

/**
 * 操作实体类定义
 * @author yang.liu
 */
public class Operation implements Serializable {

	private static final long serialVersionUID = -8007293524426345363L;

	private long operationId;
	private String operationName;
	private long moduleId;
	private String url;
	private int isMenu;
	private int isAdmin;
	private int showOrder;
	private int status;
	/**所属项目 1 减脂营 2辣妈营**/
	private Integer project; 

	public long getOperationId() {
		return operationId;
	}

	public void setOperationId(long operationId) {
		this.operationId = operationId;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(int isMenu) {
		this.isMenu = isMenu;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
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

	public Integer getProject() {
		return project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}
}
