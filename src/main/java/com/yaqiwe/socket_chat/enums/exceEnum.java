package com.yaqiwe.socket_chat.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 10:41
 * @description：错误类型枚举
 */
@Getter
public enum exceEnum{
    TOKEN_EXPIRED(4001,"token过期"),
    TOKEN_INVALID(4002,"token无效"),
    TOKEN_ERROR(4003,"token解析失败"),
    USER_LONIN_ERROR(4004,"用户名或密码错误"),

    UNKNOWN_ERROR(500,"未知错误"),
    PRIVATE_ERROR(501,"数据格式错误"),
    PRIVATE_NULL(502,"请求的服务不存在"),
    PARAMETER_ERROR(503,"参数校验错误"),

    USER_OFFLINE(5001,"用户离线"),
    REPEAT_LANDING(5002,"账号在其他地点登录"),

    SEND_MSG_ERROR(6001,"发送消息失败"),

    USER_CREATE_ERROR(7001,"用户注册失败"),
    USER_REPEAT(7002,"该用户名已存在"),
    USER_NAME_NULL(7003,"用户名不能为空"),
    USER_PASSWORD_NULL(7004,"密码不能为空")
    ;

    private Integer code;
    private String msg;

    exceEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
