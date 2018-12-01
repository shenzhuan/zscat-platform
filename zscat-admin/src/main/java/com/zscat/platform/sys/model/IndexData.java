package com.zscat.platform.sys.model;

import java.util.List;

/**
 * 用户角色权限首页数据VO定义
 * @author yang.liu
 */
public class IndexData {

    private  User user ;
    private List<Operation> operationList  ;
    private List<Menu> menuList ;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

}
