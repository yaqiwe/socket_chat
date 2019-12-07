package com.yaqiwe.socket_chat.controller;

import com.yaqiwe.socket_chat.dto.Resoult;
import com.yaqiwe.socket_chat.dto.ResoultUtil;
import com.yaqiwe.socket_chat.service.userConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/7 13:23
 * @description：
 */
@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    userConService userConS;

    @PostMapping("/createUser")
    public Resoult createUser(@RequestParam("userName")String userName,
                              @RequestParam("passWord")String passWord){
        userConS.createUser(userName,passWord);
        return ResoultUtil.success();
    }
}
