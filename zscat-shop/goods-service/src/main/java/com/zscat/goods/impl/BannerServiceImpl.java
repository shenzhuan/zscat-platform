package com.zscat.goods.impl;

import com.zscat.goods.dao.BannerDao;
import com.zscat.goods.entity.BannerDO;
import com.zscat.goods.service.BannerService;
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
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerDao bannerDao;
	
	@Override
	public BannerDO get(Long id){
		return bannerDao.get(id);
	}
	
	@Override
	public List<BannerDO> list(Map<String, Object> map){
		return bannerDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bannerDao.count(map);
	}
	
	@Override
	public int save(BannerDO banner){
		return bannerDao.save(banner);
	}
	
	@Override
	public int update(BannerDO banner){
		return bannerDao.update(banner);
	}
	
	@Override
	public int remove(Long id){
		return bannerDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return bannerDao.batchRemove(ids);
	}
	
}
