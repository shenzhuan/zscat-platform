package com.zscat.label.enums;

/**
 * 标签大类 枚举
 *
 * @author zscat
 * Created on 2018/11/5 17:59
 */
public enum LabelPartitionEnum {
    // 全部/不限
    ALL(0, "ALL"),

    // 用户标签
    USER_LABEL(1, "用户标签"),

    // 内容标签
    CONTENT_LABEL(2, "内容标签"),

    // 兼容标签
    COMPATIBLE_LABEL(3, "兼容标签");

    private int id;

    private String name;

    LabelPartitionEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getName(int id) {
        LabelPartitionEnum[] labelPartitionEnums = LabelPartitionEnum.values();
        for (LabelPartitionEnum labelPartitionEnum : labelPartitionEnums) {
            if (labelPartitionEnum.id == id) {
                return labelPartitionEnum.name;
            }
        }
        return "";
    }

    public static int getId(String name) {
        LabelPartitionEnum[] labelPartitionEnums = LabelPartitionEnum.values();
        for (LabelPartitionEnum labelPartitionEnum : labelPartitionEnums) {
            if (labelPartitionEnum.name.equals(name)) {
                return labelPartitionEnum.id;
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
