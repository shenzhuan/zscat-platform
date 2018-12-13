package com.zscat.user.impl;


import com.zscat.user.dao.CouponDao;
import com.zscat.user.entity.CouponDO;
import com.zscat.user.service.CouponService;
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
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponDao couponDao;
	
	@Override
	public CouponDO get(Long id){
		return couponDao.get(id);
	}
	
	@Override
	public List<CouponDO> list(Map<String, Object> map){
		return couponDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return couponDao.count(map);
	}
	
	@Override
	public int save(CouponDO coupon){
		return couponDao.save(coupon);
	}
	
	@Override
	public int update(CouponDO coupon){
		return couponDao.update(coupon);
	}
	
	@Override
	public int remove(Long id){
		return couponDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return couponDao.batchRemove(ids);
	}

	@Override
	public List<CouponDO> userCoupon(Map<String, Object> map) {
		return couponDao.getUserCoupon(map);
	}


	@Override
	public int removeUserCoupon(Map<String, Object> map){
		return couponDao.removeUserCoupon(map);
	}
}
