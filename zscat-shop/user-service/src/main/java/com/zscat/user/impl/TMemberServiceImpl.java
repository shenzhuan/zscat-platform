package com.zscat.user.impl;


import com.zscat.user.dao.TMemberDao;
import com.zscat.user.entity.TMemberDO;
import com.zscat.user.service.TMemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;





/**
 * Created by GeneratorFx on 2017-04-11.
 */
/**
 * @version V1.0
 * @author: zscat
 * @date: 2018/7/10
 * @Description: TODO
 */
@com.alibaba.dubbo.config.annotation.Service(
		version = "${shop.service.version}",
		application = "${dubbo.application.id}",
		registry = "${dubbo.registry.id}"
)
@Log4j2
public class TMemberServiceImpl implements TMemberService {
	@Autowired
	private TMemberDao tMemberDao;
	
	@Override
	public TMemberDO get(Long id){
		return tMemberDao.get(id);
	}
	
	@Override
	public List<TMemberDO> list(Map<String, Object> map){
		return tMemberDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tMemberDao.count(map);
	}
	
	@Override
	public int save(TMemberDO tMember){
		return tMemberDao.save(tMember);
	}
	
	@Override
	public int update(TMemberDO tMember){
		return tMemberDao.update(tMember);
	}
	
	@Override
	public int remove(Long id){
		return tMemberDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tMemberDao.batchRemove(ids);
	}

	@Override
	public TMemberDO checkUser(String username, String password) {

		return null;
	}

	@Override
	public TMemberDO selectOne(Map<String, Object> params) {
		List<TMemberDO> list = tMemberDao.list(params);
		if (list!=null && list.size()>0){
			return  list.get(0);
		}
		return null;
	}
}
