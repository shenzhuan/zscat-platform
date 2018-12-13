package com.zscat.goods.dao;



import com.zscat.goods.entity.AddressDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-20 11:41:11
 */
@Mapper
public interface AddressDao {

	AddressDO get(Long id);
	
	List<AddressDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AddressDO address);
	
	int update(AddressDO address);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    void updateToOne(Long userid);
}
