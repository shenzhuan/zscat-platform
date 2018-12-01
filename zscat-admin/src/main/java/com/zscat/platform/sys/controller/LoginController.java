package com.zscat.platform.sys.controller;


import com.alibaba.dubbo.common.utils.StringUtils;
import com.zscat.common.constants.CommonConstant;
import com.zscat.common.result.ResultInfo;
import com.zscat.common.result.ResultInfoObject;
import com.zscat.platform.sys.constant.AdminConstant;
import com.zscat.platform.sys.dao.OperationDao;
import com.zscat.platform.sys.dao.RoleDao;
import com.zscat.platform.sys.dao.UserDao;
import com.zscat.platform.sys.model.*;
import com.zscat.platform.sys.util.PassordUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 登录控制器类定义
 * @author yang.liu
 */
@Controller
public class LoginController extends BaseController {

	@Resource
	private UserDao userDao;
	@Resource
	private OperationDao operationDao;

	@Resource
	private RoleDao roleDao;

	@RequestMapping("/login.html")
	public String toLogin( HttpServletRequest request, ModelMap modelMap) {
		User user = getLoginUser(request);
		if (user!=null){
			return "/vue/index.html";
		}
		return "/vue/index.html";
	}


	@RequestMapping("/login.json")
	@ResponseBody
	public ResultInfoObject<IndexData> login(String account, String password, ModelMap modelMap, HttpServletRequest request) {
		ResultInfoObject<IndexData> resultInfo = new ResultInfoObject<IndexData>();
		if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
			resultInfo.setRetcode(CommonConstant.PARAM_ERROR_CODE);
			resultInfo.setRetdesc("用户名密码不能为空");
			return resultInfo;
		}
		User user = userDao.selectUserByAccount(account);
		if (user == null) {
			modelMap.put("msg", "用户名或者密码不正确");
			resultInfo.setRetcode(CommonConstant.PARAM_ERROR_CODE);
			resultInfo.setRetdesc("用户名密码不能为空");
			return resultInfo;
		}
		if (user.getStatus() == 0) {
			resultInfo.setRetcode(CommonConstant.PARAM_ERROR_CODE);
			resultInfo.setRetdesc("用户无效");
			return resultInfo;
		}
		if (!user.getPassword().equals(PassordUtil.encryptPassord(password))) {
			resultInfo.setRetcode(CommonConstant.PARAM_ERROR_CODE);
			resultInfo.setRetdesc("用户名或者密码不正确");
			return resultInfo;
		}
		resultInfo.setRetcode(CommonConstant.OPERATE_SUCCESS);
		resultInfo.setRetdesc("登陆成功");
		List<Role> roleList = roleDao.queryByUserId(user.getUserId());
		
		StringBuilder showRoleName = new StringBuilder();
		
		for (Role role : roleList) {
			showRoleName = showRoleName.append(role.getRoleName()).append(" & ");
		}
		
		user.setShowName(showRoleName.substring(0, showRoleName.length() - 3));

		request.getSession().setAttribute(AdminConstant.USER_SESSION_KEY, user);

		List<Operation> operationList = operationDao.selectUserOperationList(user.getUserId());
		request.getSession().setAttribute(AdminConstant.OPERATION_SESSION_KEY, operationList);
		List<Menu> menuList = operationDao.selectUserMenuList(user.getUserId());
		request.getSession().setAttribute(AdminConstant.MENU_SESSION_KEY, menuList);

		IndexData indexData = new IndexData();
		indexData.setMenuList(menuList);
		indexData.setOperationList(operationList);
		indexData.setUser(user);
		resultInfo.setObject(indexData);
		return resultInfo;
	}

	@RequestMapping("/logout.json")
	@ResponseBody
	public ResultInfo logout(HttpServletRequest request) {
		ResultInfo resultInfo = new ResultInfo();
		request.getSession().removeAttribute(AdminConstant.USER_SESSION_KEY);
		request.getSession().removeAttribute(AdminConstant.OPERATION_SESSION_KEY);
		request.getSession().removeAttribute(AdminConstant.MENU_SESSION_KEY);
		resultInfo.setRetcode(CommonConstant.OPERATE_SUCCESS);
		resultInfo.setRetdesc("操作成功");
		return resultInfo;
	}


	@RequestMapping("/checkLogin.json")
	@ResponseBody
	public ResultInfo checkLogin(HttpServletRequest request) {
		ResultInfo resultInfo = new ResultInfo();
		User user = getLoginUser(request);
		resultInfo.setRetcode(CommonConstant.OPERATE_SUCCESS);
		resultInfo.setRetdesc("登陆成功");
		if (user==null){
			resultInfo.setRetcode(CommonConstant.RET_NOT_LOGIN);
			resultInfo.setRetdesc("未登陆");
		}
		return resultInfo;
	}
	@RequestMapping("/updatePassword.json")
	@ResponseBody
	public ResultInfo updatePassword(String oldPass,String newPass,HttpServletRequest request) {
		ResultInfo resultInfo = new ResultInfo();
		if(StringUtils.isBlank(oldPass) || StringUtils.isBlank(newPass)){
			resultInfo.setRetcode(CommonConstant.PARAM_ERROR_CODE);
			resultInfo.setRetdesc("参数错误");
			return resultInfo;
		}
		User user = getLoginUser(request);
		if(!user.getPassword().equals(PassordUtil.encryptPassord(oldPass))){
			resultInfo.setRetcode(CommonConstant.PARAM_ERROR_CODE);
			resultInfo.setRetdesc("密码错误");
			return resultInfo;
		}
		userDao.updatePassword(user.getUserId(), PassordUtil.encryptPassord(newPass));
		resultInfo.setRetcode(CommonConstant.OPERATE_SUCCESS);
		resultInfo.setRetdesc("操作成功");
		return resultInfo;
	}
}
