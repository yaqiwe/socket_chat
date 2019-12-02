package com.yaqiwe.socket_chat.service;

import com.yaqiwe.socket_chat.dto.socketDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.websocket.Session;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 13:52
 * @description：用户登录注册等操作
 */
public interface userService {

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @param userSet
     * @param session
     * @return
     */
    void logIn(String userName, String passWord, CopyOnWriteArraySet<socketDto> userSet, Session session);

    /**
     * 获取该用户加入的群组列表
     * @param userName
     * @return
     */
    List<Integer> getGroupList(String userName);
}
