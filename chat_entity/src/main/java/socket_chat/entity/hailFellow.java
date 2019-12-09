package socket_chat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/8 16:33
 * @description：好友表
 */

@Data
public class hailFellow {

    private Integer userId;     //用户ID

    private Integer fellowId;       //好友ID

    private Timestamp addTime;      //添加好友时间
}
