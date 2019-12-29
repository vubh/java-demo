package com.example.v1.enums;


public enum DaysEnum {
    Mon(1, "星期一"),
    Tue(2, "星期二"),
    Wed(3, "星期三"),
    Thu(4, "星期四"),
    Fri(5, "星期五"),
    Sat(6, "星期六"),
    Sun(7, "星期日");

    public String info;
    public int code;


    DaysEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static DaysEnum stateOf(int index) {
        for (DaysEnum state : values()) {
            if (state.getCode() == index) {
                return state;
            }
        }
        return null;
    }
}
