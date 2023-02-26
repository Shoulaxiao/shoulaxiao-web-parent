package com.shoulaxiao.bookweb.common.category;

/**
 * log module
 */
public enum LogModuleEnum {

    /**
     * log module
     */
    AUTHORIZE("authorize","应用授权"),
    ;

    private String code;

    private String desc;

    /**
     * 构造方法
     *
     * @param code 标识
     * @param desc 描述
     */
    LogModuleEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static LogModuleEnum getEnumByCode(String code) {
        for (LogModuleEnum e : LogModuleEnum.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
