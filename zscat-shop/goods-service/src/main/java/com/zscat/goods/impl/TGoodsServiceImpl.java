package com.zscat.goods.impl;

import com.zscat.goods.dao.TGoodsDao;
import com.zscat.goods.entity.TGoodsDO;
import com.zscat.goods.service.TGoodsService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
public class TGoodsServiceImpl implements TGoodsService {
	@Autowired
	private TGoodsDao tGoodsDao;
	
	@Override
	public TGoodsDO get(Long id){
		return tGoodsDao.get(id);
	}
	
	@Override
	public List<TGoodsDO> list(Map<String, Object> map){
		return tGoodsDao.list(map);
	}
	@Override
	public List<TGoodsDO> list1(Map<String, Object> map){
		return tGoodsDao.list1(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tGoodsDao.count(map);
	}
	
	@Override
	public int save(TGoodsDO tGoods){
		return tGoodsDao.save(tGoods);
	}
	
	@Override
	public int update(TGoodsDO tGoods){
		return tGoodsDao.update(tGoods);
	}
	
	@Override
	public int remove(Long id){
		return tGoodsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tGoodsDao.batchRemove(ids);
	}
	@Override
	public List<TGoodsDO> selectProductByFloor(Long id) {
		return tGoodsDao.getProductByFloorid(id);
	}

	@Override
	public List<TGoodsDO> getProductByFloorid(Long tid) {
		return tGoodsDao.getProductByFloorid(tid);
	}

	@Override
	public List<TGoodsDO> selectgoodsListByType(Map<String, Object> map) {
		return tGoodsDao.selectgoodsListByType(map);
	}

	@Override
	public  List<TGoodsDO> selectGoodsByFloorLimit(Map<String, Object> map){
		return tGoodsDao.selectGoodsByFloorLimit(map);
	}
	//这里考虑代码的清晰，还是避免频繁的堆栈调用可选用不同的方式实现
	public List<TGoodsDO> getProductListByPids(String[] pids) {
		// TODO Auto-generated method stub
		List<TGoodsDO>list =new ArrayList<>();
		//这里考虑了解耦合的方式
		for(String pid:pids){
			if(StringUtils.isNoneEmpty(pid)){
			list.add(tGoodsDao.get(Long.parseLong(pid)));
		}

		}
		return list;
	}
}
