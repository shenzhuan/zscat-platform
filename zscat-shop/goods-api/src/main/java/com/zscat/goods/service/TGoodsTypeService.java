package com.zscat.goods.service;

import com.zscat.goods.entity.TGoodsTypeDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */
public interface TGoodsTypeService {
	
	TGoodsTypeDO get(Long id);
	
	List<TGoodsTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TGoodsTypeDO tGoodsType);
	
	int update(TGoodsTypeDO tGoodsType);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
