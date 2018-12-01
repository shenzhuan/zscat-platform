package com.zscat.label.enums;

/**
 * LabelUserShowEnum
 *
 * @author zscat
 * Created on 2018/10/25 12:51
 */
public enum LabelUserShowEnum {
    // 全部/不限
    ALL(0, "ALL"),


    // 不显示
    HIDE(1, "隐藏"),

    // 显示
    SHOW(2, "显示");

    private int id;

    private String name;

    LabelUserShowEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getName(int id) {
        LabelUserShowEnum[] labelUserShowEnums = LabelUserShowEnum.values();
        for (LabelUserShowEnum labelUserShowEnum : labelUserShowEnums) {
            if (labelUserShowEnum.id == id) {
                return labelUserShowEnum.name;
            }
        }
        return "";
    }

    public static int getId(String name) {
        LabelUserShowEnum[] labelUserShowEnums = LabelUserShowEnum.values();
        for (LabelUserShowEnum labelUserShowEnum : labelUserShowEnums) {
            if (labelUserShowEnum.name.equals(name)) {
                return labelUserShowEnum.id;
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
