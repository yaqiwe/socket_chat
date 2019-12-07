package com.yaqiwe.socket_chat.exception;

import com.yaqiwe.socket_chat.enums.contrEnum;
import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/6 21:43
 * @description：
 */
@Data
public class contrException extends RuntimeException {
    private Integer code;

    public contrException(contrEnum enums){
        super(enums.getMsg());
        code=enums.getCode();
    }
}
