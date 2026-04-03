package com.kunkun.springwebone.enumeration;

import lombok.Getter;

@Getter
public enum Gender {
    Boy(1, "男"),
    Girl(2, "女"),
    Unknown(0, "未知");

    private final int code;
    private final String desc;

    Gender(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() { return code; }
    public String getDesc() { return desc; }

    // 提供一个静态方法，方便从数字转枚举
    public static Gender fromCode(Integer code) {
        if (code == null) return Unknown;
        for (Gender g : Gender.values()) {
            if (g.code == code) return g;
        }
        return Unknown;
    }
}
