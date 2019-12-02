package com.yaqiwe.socket_chat.dto;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 1:07
 * @description：存储在token里面的用户信息
 */
@Data
public class tokenDto {

    private Integer userId;     //用户Id

    private String userName;        //用户名

    private String role;    //用户角色
}
