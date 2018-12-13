package com.zscat.user.dao;


import com.zscat.user.entity.CouponDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-18 13:12:04
 */
@Mapper
public interface CouponDao {

	CouponDO get(Long id);
	
	List<CouponDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CouponDO coupon);
	
	int update(CouponDO coupon);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	int removeUserCoupon(Map<String, Object> map);
    List<CouponDO> getUserCoupon(Map<String, Object> map);
}
