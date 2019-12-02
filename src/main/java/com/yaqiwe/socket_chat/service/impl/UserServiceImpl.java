package com.yaqiwe.socket_chat.service.impl;

import com.yaqiwe.socket_chat.dto.socketDto;
import com.yaqiwe.socket_chat.dto.tokenDto;
import com.yaqiwe.socket_chat.entity.user;
import com.yaqiwe.socket_chat.enums.exceEnum;
import com.yaqiwe.socket_chat.exception.socketException;
import com.yaqiwe.socket_chat.repository.userRepository;
import com.yaqiwe.socket_chat.service.senMessageService;
import com.yaqiwe.socket_chat.service.userService;
import com.yaqiwe.socket_chat.util.ResoultUtil;
import com.yaqiwe.socket_chat.util.jwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 13:55
 * @description：
 */
@Service
public class UserServiceImpl implements userService {

    @Autowired
    userRepository userR;

    @Autowired
    senMessageService senMessageS;

    @Override
    public void logIn(String userName, String passWord, CopyOnWriteArraySet<socketDto> userSet, Session session) {
        //查询用户以及对比密码
        user us = userR.findByUserName(userName);

        if(us==null || !us.getPassWord().equals(passWord)){
            throw new socketException(exceEnum.USER_LONIN_ERROR);
        }

        //用户重复登录
        for (socketDto soDto : userSet) {
            if(soDto.getId().equals(us.getUserId())){
                senMessageS.senMessage(soDto.getSession(), ResoultUtil.error(exceEnum.REPEAT_LANDING));
                userSet.remove(soDto);
                try {
                    soDto.getSession().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        tokenDto dto=new tokenDto();
        dto.setUserId(us.getUserId());
        dto.setUserName(us.getUserName());
        //TODO 用户权限
        dto.setRole(us.getRole().toString());

        String token = jwtToken.getToken(dto);
        userSet.add(new socketDto(dto.getUserId(),session));
        Map<String ,Object> map=new HashMap<>();
        map.put("token",token);
        map.put("user",dto);
        senMessageS.senMessage(session,ResoultUtil.success(map));
    }

    @Override
    public List<Integer> getGroupList(String userName) {
        //TODO 查询数据库获取群组列表
        List<Integer> groupList=new ArrayList<>();
        return groupList;
    }

}
