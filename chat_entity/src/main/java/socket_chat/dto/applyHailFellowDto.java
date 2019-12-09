package socket_chat.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/9 18:24
 * @description：
 */
@Data
public class applyHailFellowDto {

    private Integer userId;       //发送申请的用户ID

    private Timestamp addTime;      //申请好友时间

    private String userName;        //发送申请账号
}
