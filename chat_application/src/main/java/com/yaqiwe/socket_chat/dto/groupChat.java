package com.yaqiwe.socket_chat.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 15:08
 * @description：用于记录群聊消息的Dto
 */
@Data
public class groupChat {

    private Integer groupId;        //群Id

    private List<socketDto> user;      //该群聊在线的用户
}
