package com.yaqiwe.socket_chat.service;

import com.yaqiwe.socket_chat.dto.messageDto;
import com.yaqiwe.socket_chat.dto.socketDto;
import org.springframework.validation.annotation.Validated;

import javax.websocket.Session;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 14:52
 * @description：用Socket给用户发送消息
 */
public interface senMessageService {

    /**
     * 单对单私聊
     */
    void privateChat(@Validated messageDto dto, CopyOnWriteArraySet<socketDto> userSet);

    /**
     * 群聊，单对多聊天
     * @param message
     * @param userIdList
     */
    void groupChat(String message, List<Integer> userIdList);

    /**
     * 公共聊天室
     * @param dto
     * @param userSet
     */
    void publicChat(messageDto dto, CopyOnWriteArraySet<socketDto> userSet) ;

    /**
     * 发送消息
     * @param session
     * @param message
     */
    void senMessage(Session session, String message);
}
