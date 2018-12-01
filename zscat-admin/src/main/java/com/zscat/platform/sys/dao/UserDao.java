package com.zscat.platform.sys.dao;

import com.zscat.platform.sys.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Dao接口定义
 * @author yang.liu
 */
public interface UserDao {

	public User selectUserByAccount(String account);
	
	public User selectByUserId(@Param("userId") long userId);
	
	public void insertUser(User user);
	
	public void assignedDismission(@Param("userId") long userId, @Param("roleId") long roleId);

	public void updatePassword(@Param("userId") long userId, @Param("password") String password);

	public void updareDismission(@Param("userId") long userId, @Param("oldRoleId") long oldRoleId, @Param("newRoleId") long newRoleId);
	
	public User queryUserByInstructorId(long instructorId);
	
}
