package com.yaqiwe.socket_chat.service;

import com.yaqiwe.socket_chat.SocketChatApplicationTests;
import com.yaqiwe.socket_chat.enums.contrEnum;
import com.yaqiwe.socket_chat.exception.contrException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/6 16:36
 * @description：
 */
@Component
public class userServiceTest extends SocketChatApplicationTests {

    @Autowired
    userConService userS;

    @Test
    @Transactional
    public void createUser() {
        String userName = "yaqiwe4";
        String passWord = "123456";
        userS.createUser(userName, passWord);
    }

    @Test
    @Transactional
    public void createUser1() throws Exception {
        String userName = "yaqiwe3";
        String passWord = "123456";
        try {
            userS.createUser(userName, passWord);
            throw new Exception("校验失败");
        } catch (contrException e) {
            Assert.assertEquals(e.getMessage(), contrEnum.CREATE_USER_REPEAT.getMsg());
        }
    }

}
