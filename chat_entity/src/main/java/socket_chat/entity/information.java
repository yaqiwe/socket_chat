package socket_chat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 16:04
 * @description：
 */
@Data
public class information {

    private String infoId;      //自增主键

    private Integer userId;        //发送消息的用户

    private String message;     //消息内容

    private Integer receiveId;      //接收该消息的用户

    private Timestamp createTime;       //发送消息的时间

}
