package com.yaqiwe.socket_chat.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/26 22:55
 * @description：webSocket配置类
 */
@Configuration
public class socketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
