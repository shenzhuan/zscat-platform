package com.zscat.order.impl;

import com.zscat.order.dao.TOrderLogDao;
import com.zscat.order.entity.TOrderLogDO;
import com.zscat.order.service.TOrderLogService;
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
public class TOrderLogServiceImpl implements TOrderLogService {
	@Autowired
	private TOrderLogDao tOrderLogDao;
	
	@Override
	public TOrderLogDO get(Long id){
		return tOrderLogDao.get(id);
	}
	
	@Override
	public List<TOrderLogDO> list(Map<String, Object> map){
		return tOrderLogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tOrderLogDao.count(map);
	}
	
	@Override
	public int save(TOrderLogDO tOrderLog){
		return tOrderLogDao.save(tOrderLog);
	}
	
	@Override
	public int update(TOrderLogDO tOrderLog){
		return tOrderLogDao.update(tOrderLog);
	}
	
	@Override
	public int remove(Long id){
		return tOrderLogDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tOrderLogDao.batchRemove(ids);
	}
	
}
