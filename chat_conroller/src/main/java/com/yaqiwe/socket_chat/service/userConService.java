package com.yaqiwe.socket_chat.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/6 16:27
 * @description：短连接的用户操作
 */
@Validated
public interface userConService {

    /**
     * 用户注册
     * @param userName
     * @param passWord
     */
    void createUser(@NotBlank(message = "用户名不能为空") String userName,
                    @NotBlank(message = "密码不能为空") String passWord);
}
