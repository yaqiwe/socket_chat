package com.yaqiwe.socket_chat.util;

import com.alibaba.fastjson.JSON;
import com.yaqiwe.socket_chat.enums.exceEnum;
import com.yaqiwe.socket_chat.vo.Resoult;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 11:06
 * @description：
 */
public class ResoultUtil {

    //成功
    public static String success(Object data){
        Resoult resoult=new Resoult();
        resoult.setCode(200);
        resoult.setMsg("成功");
        resoult.setData(data);
        return JSON.toJSONString(resoult);
    }

    public static String success(){
        return success(null);
    }

    //失败
    public static String error(Integer code,String msg){
        Resoult resoult=new Resoult();
        resoult.setCode(code);
        resoult.setMsg(msg);
        return JSON.toJSONString(resoult);
    }

    public static String error(exceEnum emuns){
        return error(emuns.getCode(),emuns.getMsg());
    }
}
