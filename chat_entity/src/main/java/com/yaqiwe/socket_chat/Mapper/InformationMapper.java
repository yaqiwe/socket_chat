package com.yaqiwe.socket_chat.Mapper;

import com.yaqiwe.socket_chat.entity.information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 16:18
 * @description：
 */
@Mapper
public interface InformationMapper {
    /**
     * 查询数据库中的未读信息
     * @param receiceId
     * @return
     */
    @Select("select * from information wherr receive_id = #{receiceId}")
    List<information> findByReceiveId(Integer receiceId);
}
