package com.yaqiwe.socket_chat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/9 17:41
 * @description：好友申请表
 */
@Data
public class applyHailFellow {

    private Integer userId;     //发送申请的用户ID

    private Integer applyId;       //申请的用户Id

    private Timestamp addTime;      //申请时间
}
