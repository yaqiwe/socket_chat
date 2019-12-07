package com.yaqiwe.socket_chat.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/7 12:48
 * @description：
 */
@Getter
public enum contrEnum {
    CREATE_USER_ERROR(7001,"注册失败"),
    CREATE_USER_REPEAT(7002,"该用户已存在"),

    UNKNOWN_ERROR(5001,"未知错误"),

    PARAMETER_ERROR(5002,"参数校验错误"),
    ;
    private Integer code;
    private String msg;

    contrEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
