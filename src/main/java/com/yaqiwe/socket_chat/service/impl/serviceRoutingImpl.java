package com.yaqiwe.socket_chat.service.impl;

import com.alibaba.fastjson.JSON;
import com.yaqiwe.socket_chat.dto.groupChat;
import com.yaqiwe.socket_chat.dto.messageDto;
import com.yaqiwe.socket_chat.dto.socketDto;
import com.yaqiwe.socket_chat.dto.tokenDto;
import com.yaqiwe.socket_chat.enums.exceEnum;
import com.yaqiwe.socket_chat.enums.routingEnum;
import com.yaqiwe.socket_chat.exception.socketException;
import com.yaqiwe.socket_chat.service.senMessageService;
import com.yaqiwe.socket_chat.service.serviceRouting;
import com.yaqiwe.socket_chat.util.jwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 22:40
 * @description：
 */
@Service
public class serviceRoutingImpl implements serviceRouting {

    @Autowired
    senMessageService senMessageS;

    @Override
    public void routing(String message, CopyOnWriteArraySet<socketDto> userSet, CopyOnWriteArraySet<groupChat> groupSet) {
        messageDto dto = null;
        try {
            dto = JSON.parseObject(message, messageDto.class);
        } catch (Exception e) {
            throw new socketException(exceEnum.PRIVATE_ERROR);
        }
        tokenDto token = jwtToken.pareJwt(dto.getToken());
        dto.setUserName(token.getUserName());
        dto.setUserId(token.getUserId());

        if(dto.getType().equals(routingEnum.PRIVATE_CHAT.getCode())) {
            senMessageS.privateChat(dto,userSet);
        }else if(dto.getType().equals(routingEnum.PUBLIC_CHAT.getCode())){
            senMessageS.publicChat(dto,userSet);
        }else {
            throw new socketException(exceEnum.PRIVATE_NULL);
        }
    }
}
