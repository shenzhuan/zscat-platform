package com.zscat.platform.sys.controller;


import com.zscat.common.constants.CommonConstant;
import com.zscat.common.result.ResultInfoObject;
import com.zscat.platform.sys.constant.AdminConstant;
import com.zscat.platform.sys.dao.OperationDao;
import com.zscat.platform.sys.model.IndexData;
import com.zscat.platform.sys.model.Menu;
import com.zscat.platform.sys.model.Operation;
import com.zscat.platform.sys.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 后台后页面控制器类定义
 * @author yang.liu
 */
@Controller
public class IndexController {
	@Resource
	private OperationDao operationDao;

	@RequestMapping("/index.html")
	public String index() {
		return "/vue/index.html";
	}
	@RequestMapping("/index1.html")
	public String index1() {
		return "vue/index.html";
	}

	@RequestMapping("/index2.html")
	public String index2() {
		return "index.html";
	}
    @RequestMapping("/index3.html")
    public String index3() {
		return "/index.html";
    }
	@RequestMapping("/index.json")
	@ResponseBody
	public ResultInfoObject<IndexData> indexJson(HttpServletRequest request) {
		ResultInfoObject<IndexData> resultInfo = new ResultInfoObject<IndexData>();
		User user = (User) request.getSession().getAttribute(AdminConstant.USER_SESSION_KEY);
		List<Operation> operationList  = (List<Operation>)request.getSession().getAttribute(AdminConstant.OPERATION_SESSION_KEY);
		List<Menu> menuList = operationDao.selectUserMenuList(user.getUserId());

		IndexData indexData = new IndexData();
		indexData.setMenuList(menuList);
		indexData.setOperationList(operationList);

		indexData.setUser(user);
		resultInfo.setObject(indexData);
		resultInfo.setRetcode(CommonConstant.OPERATE_SUCCESS);
		resultInfo.setRetdesc("操作成功");
		return resultInfo;
	}


}
