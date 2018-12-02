package com.zscat.blog.enums;

/**
 * 标签分组 枚举
 *
 * @author zscat
 * Created on 2018/11/5 17:54
 */
public enum LabelGroupEnum {
    // 全部/不限
   // ALL(0, "ALL"),

    // 通用标签
    MANUAL(1, "通用标签"),

    // 减脂营标签
    FITCAMP_Label(2, "减脂营标签"),

    // 辣妈营标签
    HOTCAMP_Label(3, "辣妈营标签");

    private int id;

    private String name;

    LabelGroupEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String getName(int id) {
        LabelGroupEnum[] LabelTypeEnums = LabelGroupEnum.values();
        for (LabelGroupEnum LabelTypeEnum : LabelTypeEnums) {
            if (LabelTypeEnum.id == id) {
                return LabelTypeEnum.name;
            }
        }
        return "";
    }

    public static int getId(String name) {
        LabelGroupEnum[] LabelTypeEnums = LabelGroupEnum.values();
        for (LabelGroupEnum LabelTypeEnum : LabelTypeEnums) {
            if (LabelTypeEnum.name.equals(name)) {
                return LabelTypeEnum.id;
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
