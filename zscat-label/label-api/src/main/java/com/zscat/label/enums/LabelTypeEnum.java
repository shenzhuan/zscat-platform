package com.zscat.label.enums;

/**
 * 标签类型 枚举
 *
 * @author zscat
 * Created on 2018/11/5 17:54
 */
public enum LabelTypeEnum {
    // 全部/不限
    ALL(0, "ALL"),

    // 手动标签
    MANUAL(1, "手动标签"),

    // 自动标签
    AUTO(2, "自动标签");

    private int id;

    private String name;

    LabelTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getName(int id) {
        LabelTypeEnum[] labelTypeEnums = LabelTypeEnum.values();
        for (LabelTypeEnum labelTypeEnum : labelTypeEnums) {
            if (labelTypeEnum.id == id) {
                return labelTypeEnum.name;
            }
        }
        return "";
    }

    public static int getId(String name) {
        LabelTypeEnum[] labelTypeEnums = LabelTypeEnum.values();
        for (LabelTypeEnum labelTypeEnum : labelTypeEnums) {
            if (labelTypeEnum.name.equals(name)) {
                return labelTypeEnum.id;
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
