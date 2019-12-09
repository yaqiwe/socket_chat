package com.yaqiwe.socket_chat.Mapper;

import com.yaqiwe.socket_chat.SocketChatApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import socket_chat.Mapper.applyHailFellowMap;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/9 17:49
 * @description：
 */
@Component
public class applyHailFellowMapTest extends SocketChatApplicationTests {

    @Autowired
    applyHailFellowMap applyHailFellowM;

    @Test
    @Transactional
    public void insertApply() {
        applyHailFellow applyHail=new applyHailFellow();
        applyHail.setUserId(2);
        applyHail.setApplyId(1);
        int i = applyHailFellowM.insertApply(applyHail);
        Assert.assertTrue(i==1);
    }

    @Test
    @Transactional
    public void testDelete(){
        applyHailFellow applyHail=new applyHailFellow();
        applyHail.setUserId(2);
        applyHail.setApplyId(1);
        int i = applyHailFellowM.insertApply(applyHail);
        int i1 = applyHailFellowM.deleteApply(2, 1);
        Assert.assertTrue(i1==1);
    }

    @Test
    public void testDelete1(){
        int i1 = applyHailFellowM.deleteApply(1, 2);
        Assert.assertTrue(i1==0);
    }

    @Test
    public void testSelectHail(){
        Integer id=1;
        List<applyHailFellowDto> applyHail = applyHailFellowM.selectHail(id);
        Assert.assertTrue(applyHail.size()>0);
    }
}
