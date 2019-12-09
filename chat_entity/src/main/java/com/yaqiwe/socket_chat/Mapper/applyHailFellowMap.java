package com.yaqiwe.socket_chat.Mapper;

import com.yaqiwe.socket_chat.dto.applyHailFellowDto;
import com.yaqiwe.socket_chat.entity.applyHailFellow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/12/9 17:47
 * @description：
 */
@Mapper
public interface applyHailFellowMap {

    /**
     * 申请好友
     * @param applyHail
     * @return
     */
    @Insert("insert into apply_hail_fellow(user_id,apply_id)" +
            "values (#{userId},#{applyId})")
    int insertApply(applyHailFellow applyHail);

    /**
     * 删除申请记录
     * @param userId
     * @param applyId
     * @return
     */
    @Delete("delete from apply_hail_fellow where user_id= #{userId} and apply_id=#{applyId}")
    int deleteApply(Integer userId, Integer applyId);

    /**
     * 连表查询申请信息
     * @param applyId
     * @return
     */
    @Select("select apply_hail_fellow.user_id, apply_hail_fellow.add_time, user.user_name" +
            " from apply_hail_fellow LEFT JOIN user on apply_hail_fellow.apply_id=user.user_id" +
            " where apply_hail_fellow.apply_id=#{applyId}")
    List<applyHailFellowDto> selectHail(Integer applyId);
}
