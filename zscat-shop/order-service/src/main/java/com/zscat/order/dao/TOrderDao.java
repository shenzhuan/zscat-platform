package com.zscat.order.dao;


import com.zscat.order.entity.TOrderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
@Mapper
public interface TOrderDao {

	TOrderDO get(Long id);
	
	List<TOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TOrderDO tOrder);
	
	int update(TOrderDO tOrder);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
