package com.yaqiwe.socket_chat.service;

import com.yaqiwe.socket_chat.dto.groupChat;
import com.yaqiwe.socket_chat.dto.socketDto;

import javax.websocket.Session;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 22:38
 * @description：socke通信的路由
 */
public interface serviceRouting {

    /**
     * 路由
     * @param message
     */
    void routing(String message, CopyOnWriteArraySet<socketDto> userSet, CopyOnWriteArraySet<groupChat> groupSet, Session session);
}
