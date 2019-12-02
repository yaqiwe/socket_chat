package com.yaqiwe.socket_chat.service;

import com.yaqiwe.socket_chat.SocketChatApplicationTests;
import com.yaqiwe.socket_chat.dto.messageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.validator.ValidateWith;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/1 15:19
 * @description：
 */
@Component
@Slf4j
class senMessageServiceTest extends SocketChatApplicationTests {
    @Test
    void testVali(){
        messageDto dto=new messageDto();
        testMessage(dto);
    }

    void testMessage(@Valid messageDto dto){
        Assert.assertEquals(null,dto.getType());
    }

}