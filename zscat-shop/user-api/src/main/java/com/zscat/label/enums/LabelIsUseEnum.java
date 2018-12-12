package com.zscat.label.enums;

/**
 * 标签是否使用中 枚举
 *
 * @author liuruichao
 * Created on 2018/11/12 14:38
 */
public enum LabelIsUseEnum {
    // 全部/不限
    ALL(0, "ALL"),


    // 未使用
    NOT_USED(1, "未使用"),

    // 使用中
    USED(2, "使用中");

    private int id;

    private String name;

    LabelIsUseEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getName(int id) {
        LabelIsUseEnum[] labelIsUseEnums = LabelIsUseEnum.values();
        for (LabelIsUseEnum labelIsUseEnum : labelIsUseEnums) {
            if (labelIsUseEnum.id == id) {
                return labelIsUseEnum.name;
            }
        }
        return "";
    }

    public static int getId(String name) {
        LabelIsUseEnum[] labelIsUseEnums = LabelIsUseEnum.values();
        for (LabelIsUseEnum labelIsUseEnum : labelIsUseEnums) {
            if (labelIsUseEnum.name.equals(name)) {
                return labelIsUseEnum.id;
            }
        }
        return -1;
    }

    public static int getId(Integer count) {
        if (count > 0) {
            return USED.getId();
        }

        return NOT_USED.getId();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
