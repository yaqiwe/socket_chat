package com.yaqiwe.socket_chat.vo;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/30 14:17
 * @description：后端返回前端的数据格式
 */
@Data
public class messageVo {

    private Integer userId;     //发送该消息的人的用户Id

    private String userName;        //发送该消息的人的用户名

    private String message;     //发送的消息内容

    private Integer type;       //消息的类型

    public messageVo(Integer userId, String userName, String message, Integer type) {
        this.userId = userId;
        this.userName = userName;
        this.message = message;
        this.type = type;
    }

    public messageVo() {
    }
}
