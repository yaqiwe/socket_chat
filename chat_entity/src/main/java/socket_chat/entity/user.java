package socket_chat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 16:04
 * @description：
 */
@Data
public class user {

    private Integer userId;     //自增主键

    private String userName;        //账号

    private String passWord;        //密码

    private Timestamp createTime;       //创建时间

    private Integer role;       //权限

    private Timestamp updateTime;       //更新时间
}
