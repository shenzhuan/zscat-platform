package com.zscat.platform.sys.model;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {

	private static final long serialVersionUID = 4665473378084675729L;

	private long menuId;
	private String label;
	private String href;
	private Integer project; // 所属项目 1 减脂营 2辣妈营
	private List<Menu> children;

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		if (project == null){
			this.href = href;
		}else {

				this.href = href;

		}

	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public Integer getProject() {
		return project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}
}
