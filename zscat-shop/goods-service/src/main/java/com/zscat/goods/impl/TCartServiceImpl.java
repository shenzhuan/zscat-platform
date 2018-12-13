package com.zscat.goods.impl;


import com.zscat.goods.dao.TCartDao;
import com.zscat.goods.entity.TCartDO;
import com.zscat.goods.service.TCartService;
import com.zscat.goods.service.TGoodsService;
import com.zscat.goods.service.TStoreService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
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
public class TCartServiceImpl implements TCartService {
	@Autowired
	private TCartDao tCartDao;
	@Autowired
	private TStoreService tStoreService;
	@Autowired
	private TGoodsService tGoodsService;

	@Override
	public TCartDO get(Long id){
		return tCartDao.get(id);
	}
	
	@Override
	public List<TCartDO> list(Map<String, Object> map){
		return tCartDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tCartDao.count(map);
	}
	
	@Override
	public int save(TCartDO tCart){
		return tCartDao.save(tCart);
	}
	
	@Override
	public int update(TCartDO tCart){
		return tCartDao.update(tCart);
	}
	
	@Override
	public int remove(Long id){
		return tCartDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tCartDao.batchRemove(ids);
	}

	@Override
	public TCartDO selectOne(Map<String, Object> params) {
		List<TCartDO> list = tCartDao.list(params);
		if (list!=null && list.size()>0){
			return  list.get(0);
		}
		return null;
	}
	@Override
	public
	List<TCartDO> list1(Map<String, Object> map){
		return tCartDao.list1(map);
	}
	@Override
	public List<TCartDO>  selectOwnCartList(Long id){
		Map<String, Object> map = new HashMap<>();
		map.put("userid",id);
		return tCartDao.list(map);
	}
	/**
	 * 计算前
	 * @param map
	 * @return
	 */

	@Override
	public String countprice(Map<String, Object> map){
		return tCartDao.countprice(map);
	}

	@Override
	public Map<String, Object> ordersubmitpreview(Map<String, Object> params) {
		return null;
	}

	@Override
	public int selectOwnCart(Long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("userid",id);
		return tCartDao.count(map);
	}

}
