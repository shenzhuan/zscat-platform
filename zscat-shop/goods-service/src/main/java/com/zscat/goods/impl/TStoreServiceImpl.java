package com.zscat.goods.impl;

import com.zscat.goods.dao.TStoreDao;
import com.zscat.goods.entity.TStoreDO;
import com.zscat.goods.service.TStoreService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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
public class TStoreServiceImpl implements TStoreService {
	@Autowired
	private TStoreDao tStoreDao;
	
	@Override
	public TStoreDO get(Long id){
		return tStoreDao.get(id);
	}
	
	@Override
	public List<TStoreDO> list(Map<String, Object> map){
		return tStoreDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tStoreDao.count(map);
	}
	
	@Override
	public int save(TStoreDO tStore){
		tStore.setAddtime(new Date());
		return tStoreDao.save(tStore);
	}
	
	@Override
	public int update(TStoreDO tStore){
		return tStoreDao.update(tStore);
	}
	
	@Override
	public int remove(Long id){
		return tStoreDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tStoreDao.batchRemove(ids);
	}
	
}
