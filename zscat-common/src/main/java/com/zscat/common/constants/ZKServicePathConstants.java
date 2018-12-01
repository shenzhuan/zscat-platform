package com.zscat.common.constants;

/**
 * zookeeper node path constants
 *
 * @author liuruichao
 * Created on 2018/11/14 17:25
 */
public final class ZKServicePathConstants {
    public static final String ZK_CONFIG_ROOT = "/config_center/";

    /** diet-service begin */
    public static final String DIET_SERVICE_PROJECTNAME = "diet-service";

    public static final String DIET_INGREDIENTS_SERVICE_PATH = DIET_SERVICE_PROJECTNAME +  "." + "ingredientsService";

    public static final String DIET_INGREDIENTSLABEL_SERVICE_PATH = DIET_SERVICE_PROJECTNAME +  "." + "ingredientsLabelService";

    public static final String DIET_LABEL_CACHE_SERVICE_PATH = ZKServicePathConstants.DIET_SERVICE_PROJECTNAME +  "." + "LabelCacheComponent";
    /** diet-service end */
}
