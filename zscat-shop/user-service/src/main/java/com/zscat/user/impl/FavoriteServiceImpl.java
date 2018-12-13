package com.zscat.user.impl;


import com.zscat.common.utils.Query;
import com.zscat.user.dao.FavoriteDao;
import com.zscat.user.entity.FavoriteDO;
import com.zscat.user.service.FavoriteService;
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
public class FavoriteServiceImpl implements FavoriteService {
	@Autowired
	private FavoriteDao favoriteDao;
	
	@Override
	public FavoriteDO get(Long id){
		return favoriteDao.get(id);
	}
	
	@Override
	public List<FavoriteDO> list(Map<String, Object> map){
		return favoriteDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return favoriteDao.count(map);
	}
	
	@Override
	public int save(FavoriteDO favorite){
		return favoriteDao.save(favorite);
	}
	
	@Override
	public int update(FavoriteDO favorite){
		return favoriteDao.update(favorite);
	}
	
	@Override
	public int remove(Long id){
		return favoriteDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return favoriteDao.batchRemove(ids);
	}
	@Override
	public FavoriteDO selectOne(Map<String, Object> params) {
		List<FavoriteDO> list = favoriteDao.list(params);
		if (list!=null && list.size()>0){
			return  list.get(0);
		}
		return null;
	}

	@Override
	public List<FavoriteDO> userFavorite(Query query) {
		return favoriteDao.userFavorite(query);
	}
	@Override
	public List<FavoriteDO> userTopicFavorite(Query query) {
		return favoriteDao.userTopicFavorite(query);
	}
}
