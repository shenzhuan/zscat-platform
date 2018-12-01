package com.zscat.platform.label.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zscat.common.constants.CommonConstant;
import com.zscat.common.page.Paging;
import com.zscat.common.result.ResultInfoObject;
import com.zscat.label.entity.LabelVO;
import com.zscat.label.service.LabelGroupService;
import com.zscat.label.service.LabelRelationService;
import com.zscat.label.service.LabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台-用户标签接口
 * @author bikaichuan
 * @date 2018-11-14
 */
@Controller
@RequestMapping("/crm/label")
public class LabelController {

    @Reference(
            version = "${label.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    LabelRelationService labelRelationService;

    @Reference(
            version = "${label.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    LabelService labelService;

    @Reference(
            version = "${label.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    LabelGroupService labelGroupService;



    private Logger log = LoggerFactory.getLogger(getClass());

    private static final String ZERO_STR = "0";

    private static final String ALL_STR_CHINESE = "全部";

    private static final String ALL_STR = "ALL";

    /**
     * 标签管理 - 获取标签列表
     *
     * @param labelVO
     * @return
     */
    @RequestMapping("list.json")
    @ResponseBody
    public ResultInfoObject list(LabelVO labelVO) {

        Paging paging = new Paging(1, 10);
        if (null == labelVO) {
            labelVO = new LabelVO();
        } else {
            if (labelVO.getPage() == null || labelVO.getPageSize() == null) {
                labelVO.setPage(paging.getPage());
                labelVO.setPageSize(paging.getPageSize());
            }
        }
        ResultInfoObject resultInfoObject = new ResultInfoObject();
        try {
            Long count = labelService.listCount(labelVO);
            List<LabelVO> labelVOS = labelService.list(labelVO);

            int total = null != count ? count.intValue() : 0;
            paging.setTotal(total);
            int totalPage = 0;
            if (null != count) {
                totalPage = (int) (count / paging.getPageSize());
                if (count % paging.getPageSize() != 0) {
                    totalPage += 1;
                }
            }
            paging.setTotalPage(totalPage);

            Map<String, Object> map = new HashMap<>();
            map.put("list", labelVOS);
            map.put("paging", paging);
            resultInfoObject.setRetcode(CommonConstant.OPERATE_SUCCESS);
            resultInfoObject.setRetdesc("操作成功");
            resultInfoObject.setObject(map);
        } catch (Exception e) {
            log.info("LabelController list error " + e.getMessage());
            resultInfoObject.setRetcode(CommonConstant.OPERATE_FAIL);
            resultInfoObject.setRetdesc("操作失败");
            resultInfoObject.setObject(null);
        }

        return resultInfoObject;
    }



}
