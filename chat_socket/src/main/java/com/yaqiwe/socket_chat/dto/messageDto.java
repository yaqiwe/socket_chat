package com.yaqiwe.socket_chat.dto;

import com.yaqiwe.socket_chat.groups.privateChat;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 22:01
 * @description：前端调用后端服务的数据格式
 */
@Data
public class messageDto {

    @NotNull(message = "服务类型不能为空")
    private Integer type;       //通信类型

    private Integer userId;     //消息发送者的Id

    @NotNull(message = "消息接收者ID不能为空",groups = privateChat.class)
    private Integer receive;        //消息接收者的ID 或群组ID

    private String token;       //登录状态码

    @NotBlank(message = "消息内容不能为空")
    private String data;     //消息内容

    private String userName;    //用户名
}
