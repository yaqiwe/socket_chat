package com.yaqiwe.socket_chat.exception;

import com.yaqiwe.socket_chat.enums.exceEnum;
import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 10:40
 * @description：自定义异常
 */
@Data
public class socketException extends RuntimeException {

    private Integer code;

    public socketException(exceEnum enums){
        super(enums.getMsg());
        code=enums.getCode();
    }
}
