package com.yaqiwe.socket_chat.repository;

import com.yaqiwe.socket_chat.entity.information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/27 16:18
 * @description：
 */
@Repository
public interface informationRepository extends JpaRepository<information,String> {
    /**
     * 查询数据库中的未读信息
     * @param receiceId
     * @return
     */
    List<information> findByReceiveId(Integer receiceId);
}
