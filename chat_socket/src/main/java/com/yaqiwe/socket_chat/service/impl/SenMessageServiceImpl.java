package com.yaqiwe.socket_chat.service.impl;

import com.yaqiwe.socket_chat.dto.messageDto;
import com.yaqiwe.socket_chat.dto.socketDto;
import com.yaqiwe.socket_chat.enums.exceEnum;
import com.yaqiwe.socket_chat.exception.socketException;
import com.yaqiwe.socket_chat.service.senMessageService;
import com.yaqiwe.socket_chat.socket.webSocketServer;
import com.yaqiwe.socket_chat.util.ResoultUtil;
import com.yaqiwe.socket_chat.vo.messageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.websocket.Session;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 15:33
 * @description：
 */
@Service
public class SenMessageServiceImpl implements senMessageService {

    @Autowired
    webSocketServer webSocketS;

    @Override
    public void privateChat(messageDto dto, CopyOnWriteArraySet<socketDto> userSet) {
        if(dto.getUserId()==null || dto.getUserName().isEmpty() || dto.getData()==null || dto.getReceive()==null){
            throw new socketException(exceEnum.PRIVATE_ERROR);
        }
        messageVo vo = new messageVo(dto.getUserId(), dto.getUserName(), dto.getData(), dto.getType());
        for (socketDto soDto : userSet) {
            if (soDto.getId().equals(dto.getReceive())) {
                senMessage(soDto.getSession(), ResoultUtil.success(vo));
                return;
            }
        }
    }

    @Override
    public void groupChat(String message, List<Integer> userIdList) {
        //TODO
    }

    @Override
    public void publicChat(messageDto dto, CopyOnWriteArraySet<socketDto> userSet) {
        if(dto.getUserId()==null || dto.getUserName().isEmpty() || dto.getData()==null){
            throw new socketException(exceEnum.PRIVATE_ERROR);
        }
        messageVo vo = new messageVo(dto.getUserId(), dto.getUserName(), dto.getData(), dto.getType());
        for (socketDto soDto : userSet) {
            senMessage(soDto.getSession(), ResoultUtil.success(vo));
        }
    }

    public void senMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            throw new socketException(exceEnum.SEND_MSG_ERROR);
        }
    }


}
