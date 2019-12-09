package com.yaqiwe.socket_chat.Mapper;

import com.yaqiwe.socket_chat.SocketChatApplicationTests;
import com.yaqiwe.socket_chat.dto.hailFellowDto;
import com.yaqiwe.socket_chat.entity.hailFellow;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/8 17:20
 * @description：
 */
@Component
public class hailFellowMapperTest extends SocketChatApplicationTests {
    @Autowired
    hailFellowMapper hailFellowM;

    @Test
    @Transactional
    public void insert() {
        hailFellow fellow=new hailFellow();
        fellow.setUserId(1);
        fellow.setFellowId(2);
        int in = hailFellowM.insert(fellow);
        Assert.assertTrue(in==1);
    }

    @Test
    @Transactional
    public void delete(){
        hailFellow fellow=new hailFellow();
        fellow.setUserId(1);
        fellow.setFellowId(2);
        int in = hailFellowM.insert(fellow);
        int delete = hailFellowM.delete(1, 2);
        Assert.assertTrue(delete==1);
    }

    @Test
    @Transactional
    public void delete1(){
        int delete = hailFellowM.delete(1, 2);
        Assert.assertTrue(delete==0);
    }

    @Test
    public void testSelectHail(){
        Integer id=1;
        List<hailFellowDto> ha = hailFellowM.selectHail(id);
        Assert.assertTrue(ha.size()>0);
    }
}
