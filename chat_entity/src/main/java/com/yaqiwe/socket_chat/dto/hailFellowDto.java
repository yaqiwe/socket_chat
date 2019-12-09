package com.yaqiwe.socket_chat.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/9 17:21
 * @description：
 */
@Data
public class hailFellowDto {

    private Integer fellowId;       //好友ID

    private Timestamp addTime;      //添加好友时间

    private String userName;        //账号
}
