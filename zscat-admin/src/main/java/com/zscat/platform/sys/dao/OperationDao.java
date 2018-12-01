package com.zscat.platform.sys.dao;


import com.zscat.platform.sys.model.Menu;
import com.zscat.platform.sys.model.Operation;

import java.util.List;

/**
 * 操作Dao接口定义
 * @author yang.liu
 */
public interface OperationDao {

	public List<Operation> selectUserOperationList(long userId);
	
	public List<Menu> selectUserMenuList(long userId);
}
