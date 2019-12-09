package com.yaqiwe.socket_chat.Mapper;

import com.yaqiwe.socket_chat.dto.hailFellowDto;
import com.yaqiwe.socket_chat.entity.hailFellow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/8 17:17
 * @description：
 */
@Mapper
public interface hailFellowMapper {

    /**
     * 添加好友
     * @param fellow
     * @return
     */
    @Insert("insert into hail_fellow(user_id,fellow_id)" +
            "values (#{userId},#{fellowId})")
    int insert(hailFellow fellow);


    /**
     * 删除好友
     * @param userId
     * @param fellowId
     * @return
     */
    @Delete("delete from hail_fellow where user_id= #{userId} and fellow_id= #{fellowId}")
    int delete(Integer userId, Integer fellowId);


    /**
     * 连表查询好友信息
     * @param userId
     * @return
     */
    @Select("select hail_fellow.fellow_id,hail_fellow.add_time,user.user_name" +
            " from hail_fellow LEFT JOIN user on hail_fellow.fellow_id=user.user_id" +
            " where hail_fellow.user_id=#{userId}")
    List<hailFellowDto> selectHail(Integer userId);

}
