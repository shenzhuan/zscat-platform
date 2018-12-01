package com.zscat.label.utils;

import com.google.common.base.Preconditions;
import com.zscat.label.enums.LabelTypeEnum;
import com.zscat.label.entity.Label;

/**
 * LabelUtils
 *
 * @author zscat
 * Created on 2018/11/12 10:46
 */
public final class LabelUtils {
    /**
     * 生成label redis缓存key
     * @param labelId 标签ID
     * @return redisKey
     */
    public static String genRedisKey(Integer labelId) {
        return "fittime_label_" + labelId;
    }

    /**
     * 生成label relation redis key
     * @param relationId ID
     * @param relationType type
     * @return redisKey
     */
    public static String genRelationRedisKey(Integer relationId, Integer relationType) {
        return "fittime_label_relationid_" + relationId + "_relationtype_" + relationType;
    }

    /**
     * 判断标签是否为自动标签
     * @param label 标签
     * @return true: 是自动标签  false: 不是自动标签
     */
    public static boolean isAutoLabel(Label label) {
        Preconditions.checkNotNull(label);

        if (LabelTypeEnum.AUTO.getId() == label.getLabelType()) {
            return true;
        }

        return false;
    }
}
