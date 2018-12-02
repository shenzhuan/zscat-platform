package com.zscat.platform.system.service;

import com.zscat.platform.common.domain.Tree;
import com.zscat.platform.system.domain.DeptDO;
import com.zscat.platform.system.domain.UserDO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface UserService {
	UserDO get(Long id);

	List<UserDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserDO user);
	int saveOnly(UserDO user);

	int update(UserDO user);
	int updateOnly(UserDO user);
	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	int resetPwd(UserDO user);

	Tree<DeptDO> getTree();
	/**
	 * 合并微信用户信息
	 *
	 * @param wxOauthCode
	 * @return
	 */
	UserDO mergeUserInfo(String wxOauthCode);

	/**
	 * 根据 微信openid查询
	 * @param openid
	 * @return
	 */
	UserDO getByWxOpenId(String openid);
}
