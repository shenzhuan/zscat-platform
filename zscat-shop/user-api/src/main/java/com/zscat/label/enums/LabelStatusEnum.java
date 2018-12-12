package com.zscat.label.enums;

/**
 * 标签状态 枚举
 *
 * @author liuruichao
 * Created on 2018/11/5 17:52
 */
public enum LabelStatusEnum {
    // 全部/不限
    ALL(0, "ALL"),

    // 激活
    ENABLE(1, "激活"),

    // 已停用
    DISABLE(2, "已停用");

    private int id;

    private String name;

    LabelStatusEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getName(int id) {
        LabelStatusEnum[] labelStatusEnums = LabelStatusEnum.values();
        for (LabelStatusEnum labelStatusEnum : labelStatusEnums) {
            if (labelStatusEnum.id == id) {
                return labelStatusEnum.name;
            }
        }
        return "";
    }

    public static int getId(String name) {
        LabelStatusEnum[] labelStatusEnums = LabelStatusEnum.values();
        for (LabelStatusEnum labelStatusEnum : labelStatusEnums) {
            if (labelStatusEnum.name.equals(name)) {
                return labelStatusEnum.id;
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
