package com.zscat.blog.impl;


import com.zscat.blog.dao.PartnerMapper;
import com.zscat.blog.entity.Pager;
import com.zscat.blog.entity.Partner;
import com.zscat.blog.service.PartnerService;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version V1.0
 * @author: zscat
 * @date: 2018/7/10
 * @Description: TODO
 */
@com.alibaba.dubbo.config.annotation.Service(
        version = "${blog.service.version}",
        application = "${dubbo.application.id}",
        registry = "${dubbo.registry.id}"
)
@Log4j2
public class PartnerServiceImpl implements PartnerService {

    @Resource
    private PartnerMapper partnerMapper;


    @Override
    public List<Partner> findAll() {
        return partnerMapper.findAll();
    }

    @Override
    public void savePartner(Partner partner) {
        partnerMapper.savePartner(partner);
    }

    @Override
    public List<Partner> loadPartner(Pager pager, String param) {
        pager.setStart(pager.getStart());
        return partnerMapper.loadPartner(pager,param);
    }

    @Override
    public Partner getPartnerById(Integer id) {
        return partnerMapper.getPartnerById(id);
    }

    @Override
    public void deletePartner(Integer id) {
        partnerMapper.deletePartner(id);
    }

    @Override
    public void updatePartner(Partner partner) {
        partnerMapper.updatePartner(partner);
    }

    @Override
    public void initPage(Pager pager) {
        int count = partnerMapper.initPage(pager);
        pager.setTotalCount(count);
    }

}
