package com.zscat.label.enums;

/**
 * 标签关联类型 枚举
 *
 * @author zscat
 * Created on 2018/11/5 17:45
 */
public enum LabelRelationTypeEnum {
    // 全部/不限
    ALL(0, "ALL"),

    // 用户
    USER(1, "用户"),

    // 食材
    INGREDIENTS(2, "食材"),

    // 营销软文(废弃)
    @Deprecated
    MARKETING(3, "营销软文"),

    // 标签
    LABEL(4, "标签"),

    // 任务
    TASK(5, "任务"),

    // 媒体资源/营销软文
    CONTENT(6, "媒体资源"),

    // 问卷
    QUESTION(7, "问卷");

    private int id;

    private String name;

    LabelRelationTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getName(int id) {
        LabelRelationTypeEnum[] labelRelationTypeEnums = LabelRelationTypeEnum.values();
        for (LabelRelationTypeEnum labelRelationTypeEnum : labelRelationTypeEnums) {
            if (labelRelationTypeEnum.id == id) {
                return labelRelationTypeEnum.name;
            }
        }
        return "";
    }

    public static int getId(String name) {
        LabelRelationTypeEnum[] labelRelationTypeEnums = LabelRelationTypeEnum.values();
        for (LabelRelationTypeEnum labelRelationTypeEnum : labelRelationTypeEnums) {
            if (labelRelationTypeEnum.name.equals(name)) {
                return labelRelationTypeEnum.id;
            }
        }
        return -1;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
