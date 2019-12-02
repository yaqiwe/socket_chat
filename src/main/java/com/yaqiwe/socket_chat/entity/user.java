package com.yaqiwe.socket_chat.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 16:04
 * @description：
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;     //自增主键

    private String userName;        //账号

    private String passWord;        //密码

    private Timestamp createTime;       //创建时间

    private Integer role;       //权限

    private Timestamp updateTime;       //更新时间
}
