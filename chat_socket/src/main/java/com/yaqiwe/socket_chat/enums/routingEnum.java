package com.yaqiwe.socket_chat.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 22:51
 * @description：
 */
@Getter
public enum routingEnum {
    PRIVATE_CHAT(10001,"私聊"),
    PUBLIC_CHAT(10002,"公共聊天室"),
    USER_LONIN_TYPE(10000,"用户登录"),

    ;
    private Integer code;
    private String msg;

    routingEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
