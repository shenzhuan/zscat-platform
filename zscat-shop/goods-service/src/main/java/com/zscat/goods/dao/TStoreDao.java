package com.zscat.goods.dao;

import com.zscat.goods.entity.TStoreDO;
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
public interface TStoreDao {

	TStoreDO get(Long id);
	
	List<TStoreDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TStoreDO tStore);
	
	int update(TStoreDO tStore);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
