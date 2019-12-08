package com.yaqiwe.socket_chat.Mapper;


import com.yaqiwe.socket_chat.entity.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/30 13:01
 * @description：
 */
@Mapper
public interface userMapper  {

    /**
     * 查询用户
     * @param userName
     * @return
     */
    @Select("select * from user where user_name = #{userName}")
    user findByUserName(String userName);

    @Insert("insert into user (user_name,pass_word,role)" +
            "values (#{userName},#{passWord},#{role})")
    int save(user us);
}
