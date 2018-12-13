package com.zscat.goods.impl;

import com.zscat.goods.dao.AddressDao;
import com.zscat.goods.entity.AddressDO;
import com.zscat.goods.service.AddressService;
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
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public AddressDO get(Long id){
		return addressDao.get(id);
	}
	
	@Override
	public List<AddressDO> list(Map<String, Object> map){
		return addressDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return addressDao.count(map);
	}
	
	@Override
	public int save(AddressDO address){
		return addressDao.save(address);
	}
	
	@Override
	public int update(AddressDO address){
		return addressDao.update(address);
	}
	
	@Override
	public int remove(Long id){
		return addressDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return addressDao.batchRemove(ids);
	}

	@Override
	public AddressDO selectOne(Map<String, Object> params) {
		List<AddressDO> list = addressDao.list(params);
		if (list!=null && list.size()>0){
			return  list.get(0);
		}
		return null;
	}
	public int save1(AddressDO address){
		if (address.getIsdefault() == 0){
			addressDao.updateToOne(address.getUserid());
		}
		return addressDao.save(address);
	}
}
