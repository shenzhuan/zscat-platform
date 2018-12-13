package com.zscat.goods.impl;

import com.zscat.goods.dao.TBrandDao;
import com.zscat.goods.entity.TBrandDO;
import com.zscat.goods.service.TBrandService;
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
public class TBrandServiceImpl implements TBrandService {
	@Autowired
	private TBrandDao tBrandDao;
	
	@Override
	public TBrandDO get(Long id){
		return tBrandDao.get(id);
	}
	
	@Override
	public List<TBrandDO> list(Map<String, Object> map){
		return tBrandDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tBrandDao.count(map);
	}
	
	@Override
	public int save(TBrandDO tBrand){
		return tBrandDao.save(tBrand);
	}
	
	@Override
	public int update(TBrandDO tBrand){
		return tBrandDao.update(tBrand);
	}
	
	@Override
	public int remove(Long id){
		return tBrandDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tBrandDao.batchRemove(ids);
	}
	@Override
	public
	List<TBrandDO> getBrandByFloorid(Long id){
		return tBrandDao.getBrandByFloorid(id);
	}
}
