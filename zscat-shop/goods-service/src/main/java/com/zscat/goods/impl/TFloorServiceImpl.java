package com.zscat.goods.impl;

import com.zscat.goods.dao.TFloorDao;
import com.zscat.goods.entity.TFloorDO;
import com.zscat.shop.service.TFloorService;
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
public class TFloorServiceImpl implements TFloorService {
	@Autowired
	private TFloorDao tFloorDao;
	
	@Override
	public TFloorDO get(Long id){
		return tFloorDao.get(id);
	}
	
	@Override
	public List<TFloorDO> list(Map<String, Object> map){
		return tFloorDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tFloorDao.count(map);
	}
	
	@Override
	public int save(TFloorDO tFloor){
		return tFloorDao.save(tFloor);
	}
	
	@Override
	public int update(TFloorDO tFloor){
		return tFloorDao.update(tFloor);
	}
	
	@Override
	public int remove(Long id){
		return tFloorDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tFloorDao.batchRemove(ids);
	}
	
}
