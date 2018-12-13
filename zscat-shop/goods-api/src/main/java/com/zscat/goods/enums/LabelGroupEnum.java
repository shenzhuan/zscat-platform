package com.zscat.goods.enums;

/**
 * 标签分组 枚举
 *
 * @author liuruichao
 * Created on 2018/11/5 17:54
 */
public enum LabelGroupEnum {
    // 全部/不限
   // ALL(0, "ALL"),

    // 通用标签
    MANUAL(1, "通用标签"),

    // 减脂营标签
    FITCAMP_LABEL(2, "减脂营标签"),

    // 辣妈营标签
    HOTCAMP_LABEL(3, "辣妈营标签");

    private int id;

    private String name;

    LabelGroupEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getName(int id) {
        LabelGroupEnum[] labelTypeEnums = LabelGroupEnum.values();
        for (LabelGroupEnum labelTypeEnum : labelTypeEnums) {
            if (labelTypeEnum.id == id) {
                return labelTypeEnum.name;
            }
        }
        return "";
    }

    public static int getId(String name) {
        LabelGroupEnum[] labelTypeEnums = LabelGroupEnum.values();
        for (LabelGroupEnum labelTypeEnum : labelTypeEnums) {
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
    
    public static void main(String[] args) {
    	System.out.println(getName(3));
    }
}
