package com.yaqiwe.socket_chat.service.impl;

import com.yaqiwe.socket_chat.entity.user;
import com.yaqiwe.socket_chat.enums.contrEnum;
import com.yaqiwe.socket_chat.exception.contrException;
import com.yaqiwe.socket_chat.Mapper.userMapper;
import com.yaqiwe.socket_chat.service.userConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/6 16:28
 * @description：
 */
@Service
public class userConServiceImpl implements userConService {

    @Autowired
    userMapper userR;

    @Override
    public void createUser(String userName, String passWord) {
        user us = userR.findByUserName(userName);
        if(us!=null){
            throw new contrException(contrEnum.CREATE_USER_REPEAT);
        }
        us=new user();
        us.setUserName(userName);
        us.setPassWord(passWord);
        us.setRole(1);
        int saveInt = userR.save(us);
        if(saveInt!=1){
            throw new contrException(contrEnum.CREATE_USER_ERROR);
        }
    }
}
