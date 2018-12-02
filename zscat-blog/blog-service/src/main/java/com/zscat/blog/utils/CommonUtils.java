package com.zscat.blog.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * CommonUtils
 *
 * @author zscat
 * Created on 2018/10/13 13:16
 */
public final class CommonUtils {
    /**
     * 获取SpringBean property为null的字段名称
     * @param source 实体
     * @return property为null的字段名称数组
     */
    public static String[] getBeanNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 校验集合不是null并且size>0
     * @param collection 集合
     * @return true: 不为null false: 为null
     */
    public static boolean checkCollecitonNotEmpty(Collection<?> collection) {
        return collection != null && collection.size() > 0;
    }

    /**
     * 格式化double，保留一位小数，四舍五入
     * @return 保留一位小数，四舍五入
     */
    public static String formatNumber(double num) {
        DecimalFormat df = new DecimalFormat("#.0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(num);
    }

    /**
     * 拷贝properties，忽略null值
     * @param source source
     * @param target target
     */
    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getBeanNullPropertyNames(source));
    }

    /**
     * 生成饮食计划状态rediskey
     * @param applyId 报名ID
     * @return
     */
    public static String buildDietPlanStatusRedisKey(String applyId) {
        return "fittime_diet_plan_gen_status_" + applyId;
    }
}
