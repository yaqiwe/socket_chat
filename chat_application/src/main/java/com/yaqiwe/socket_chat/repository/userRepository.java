package com.yaqiwe.socket_chat.repository;

import com.yaqiwe.socket_chat.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/30 13:01
 * @description：
 */
public interface userRepository extends JpaRepository<user,Integer> {

    /**
     * 查询用户
     * @param userName
     * @return
     */
    user findByUserName(String userName);
}
