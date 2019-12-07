package com.yaqiwe.socket_chat.service.impl;

import com.yaqiwe.socket_chat.dto.testDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/7 15:34
 * @description：
 */
@Service
@Validated
public class testVali {

    public void ok(@Valid testDto dto){

    }
}
