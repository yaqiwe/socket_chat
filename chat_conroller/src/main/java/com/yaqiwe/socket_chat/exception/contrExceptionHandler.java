package com.yaqiwe.socket_chat.exception;

import com.yaqiwe.socket_chat.dto.Resoult;
import com.yaqiwe.socket_chat.dto.ResoultUtil;
import com.yaqiwe.socket_chat.enums.contrEnum;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/7 13:32
 * @description：
 */
@ControllerAdvice
@ResponseBody
public class contrExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Resoult contrExcHandler(Exception e){
        if(e instanceof contrException){
            contrException ce= (contrException) e;
            return ResoultUtil.error(ce.getCode(),ce.getMessage());
        }else {
            e.printStackTrace();
            return ResoultUtil.error(contrEnum.UNKNOWN_ERROR);
        }
    }

    /**
     * 单个参数校验
     * @param
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Resoult handleBindGetException(ConstraintViolationException ex){
        List<String> defaultMsg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return  ResoultUtil.error(contrEnum.PARAMETER_ERROR.getCode(),defaultMsg.toString());
    }

    /**
     * 一般的参数绑定时候抛出的异常
     * @param
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public Resoult handleBindException(BindException ex){
        List<String> defaultMsg = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return ResoultUtil.error(contrEnum.PARAMETER_ERROR.getCode(),defaultMsg.toString());
    }
}
