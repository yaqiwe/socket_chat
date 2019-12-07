package com.yaqiwe.socket_chat.dto;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 11:05
 * @description：
 */
@Data
public class Resoult<T> {

    private Integer code;   /*正确&错误放回吗*/

    private String msg;     /*返回信息*/

    private T data;     /*请求的数据*/

}
