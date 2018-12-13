package com.zscat.goods.impl;

import com.zscat.goods.dao.UserJfgoodsDao;
import com.zscat.goods.entity.UserJfgoodsDO;
import com.zscat.shop.service.UserJfgoodsService;
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
public class UserJfgoodsServiceImpl implements UserJfgoodsService {
	@Autowired
	private UserJfgoodsDao userJfgoodsDao;
	
	@Override
	public UserJfgoodsDO get(Long id){
		return userJfgoodsDao.get(id);
	}
	
	@Override
	public List<UserJfgoodsDO> list(Map<String, Object> map){
		return userJfgoodsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userJfgoodsDao.count(map);
	}
	
	@Override
	public int save(UserJfgoodsDO userJfgoods){
		return userJfgoodsDao.save(userJfgoods);
	}
	
	@Override
	public int update(UserJfgoodsDO userJfgoods){
		return userJfgoodsDao.update(userJfgoods);
	}
	
	@Override
	public int remove(Long id){
		return userJfgoodsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userJfgoodsDao.batchRemove(ids);
	}
	
}
