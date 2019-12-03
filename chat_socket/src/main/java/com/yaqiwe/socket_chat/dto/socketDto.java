package com.yaqiwe.socket_chat.dto;

import lombok.Data;

import javax.websocket.Session;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/26 23:08
 * @description：webSocket存储对象
 */
@Data
public class socketDto {

    private Integer Id;

    private Session session;

    public socketDto(Integer id, Session session) {
        Id = id;
        this.session = session;
    }
}
