package com.zscat.order.dao;


import com.zscat.order.entity.TOrderLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 订单处理历史表
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:37
 */
@Mapper
public interface TOrderLogDao {

	TOrderLogDO get(Long id);
	
	List<TOrderLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TOrderLogDO tOrderLog);
	
	int update(TOrderLogDO tOrderLog);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
