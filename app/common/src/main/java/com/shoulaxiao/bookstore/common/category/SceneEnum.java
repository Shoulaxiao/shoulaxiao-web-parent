package com.shoulaxiao.bookstore.common.category;

/**
 * 业务场景
 */
public enum SceneEnum {

    /**
     * 业务场景
     */
    LOGIN_IN("loginIn","登录"),
    SIGN_OUT("signOut", "注销")
    ;

    private String code;

    private String desc;


    /**
     * 构造方法
     *
     * @param code 标识
     * @param desc 描述
     */
    SceneEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SceneEnum getEnumByCode(String code) {
        for (SceneEnum e : SceneEnum.values()) {
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
