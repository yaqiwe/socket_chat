package com.yaqiwe.socket_chat.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/7 15:35
 * @description：
 */
@Data
public class testDto {

    @NotBlank(message = "不为空")
    private String userNama;

    @NotBlank(message = "2不为空")
    private String passWork;
}
