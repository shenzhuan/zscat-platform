package com.zscat.order.impl;


import com.zscat.common.utils.R;
import com.zscat.common.utils.RandomString;
import com.zscat.goods.entity.TGoodsDO;
import com.zscat.goods.service.TGoodsService;
import com.zscat.order.dao.TOrderDao;
import com.zscat.order.dao.TOrderLogDao;
import com.zscat.order.entity.TOrderDO;
import com.zscat.order.entity.TOrderLogDO;
import com.zscat.order.service.TOrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
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
public class TOrderServiceImpl implements TOrderService {
	@Autowired
	private TOrderDao tOrderDao;
	@Autowired
	private TOrderLogDao tOrderLogDao;
	@Autowired
	private TGoodsService tGoodsService;
	
	@Override
	public TOrderDO get(Long id){
		return tOrderDao.get(id);
	}
	
	@Override
	public List<TOrderDO> list(Map<String, Object> map){
		return tOrderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tOrderDao.count(map);
	}
	
	@Override
	public int save(TOrderDO tOrder){
		return tOrderDao.save(tOrder);
	}
	
	@Override
	public int update(TOrderDO tOrder){
		return tOrderDao.update(tOrder);
	}
	
	@Override
	public int remove(Long id){
		return tOrderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tOrderDao.batchRemove(ids);
	}

	@Override
	public TOrderDO insertWapOrder(Long productId, Long addressid, Long paymentid, String usercontent, Long id, String username) {
		TOrderDO order=new TOrderDO();
		TGoodsDO p =tGoodsService.get(productId);
		order.setOrdersn(RandomString.generateRandomString(8));
		order.setCreatedate(new Date());
		order.setStatus(1);
		order.setUserid(id);
		order.setUsername(username);
		order.setPaymentid(paymentid);
		order.setUsercontent(usercontent);
		order.setAddressid(addressid);
		order.setTotalcount(1);
		order.setTotalprice(BigDecimal.valueOf(Double.valueOf(p.getPrices())));
		tOrderDao.save(order);

		TOrderLogDO log=new TOrderLogDO();
		log.setOrderId(order.getId());
		log.setOrderState("1");
		log.setStateInfo("提交订单");
		log.setCreateTime(System.currentTimeMillis());
		log.setOperator(username);
		tOrderLogDao.save(log);

		return order;
	}

	@Override
	public TOrderDO submitOrder(Long id) {
		return null;
	}

	@Override
	public R balancePay(Long id) {
		return null;
	}

}
