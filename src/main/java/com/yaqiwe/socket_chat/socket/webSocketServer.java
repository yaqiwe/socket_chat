package com.yaqiwe.socket_chat.socket;

import com.yaqiwe.socket_chat.dto.groupChat;
import com.yaqiwe.socket_chat.dto.socketDto;
import com.yaqiwe.socket_chat.enums.exceEnum;
import com.yaqiwe.socket_chat.exception.socketException;
import com.yaqiwe.socket_chat.service.serviceRouting;
import com.yaqiwe.socket_chat.service.userService;
import com.yaqiwe.socket_chat.util.ResoultUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/11/26 23:04
 * @description：
 */
@ServerEndpoint(value = "/login/{userName}/{passWork}")
@Component
@Slf4j
@Getter
public class webSocketServer {

    // concurrent包的线程安全Set，用来存放每个客户端对应的Session对象。
    private static CopyOnWriteArraySet<socketDto> userSet = new CopyOnWriteArraySet<socketDto>();

    //存放群聊的Session
    private static CopyOnWriteArraySet<groupChat> groupSet=new CopyOnWriteArraySet<>();

    private static userService userS ;

    private static serviceRouting routing;


    //当前用户Session
    private Session session;

    @Autowired
    public void setUserService(userService userS){
        this.userS=userS;
    }
    @Autowired
    public void setRouting(serviceRouting routing) {
        webSocketServer.routing = routing;
    }

    @OnOpen
    public void onOpen(Session session,
                       @PathParam(value = "userName") String userName,
                       @PathParam(value = "passWork") String passWork) throws IOException {
        this.session=session;
        //登录验证,并返回token给前端
        userS.logIn(userName, passWork,userSet,session);

        //TODO 将该用户加入该用户加入的群组
    }

    @OnClose
    public void onClose(){
        for (socketDto soc : userSet) {
            if(session.getId().equals(soc.getSession().getId())){
                userSet.remove(soc);
                log.info("Socket 在线人数: {}",userSet.size());
                break;
            }
        }
    }

    @OnMessage
    public void onMessage(String message){
        routing.routing(message,userSet,groupSet);
    }

    @OnError
    public void onError(Throwable error){
        try {
            /*自定义的错误类型*/
            if (error instanceof socketException) {
                socketException ce = (socketException) error;
                session.getBasicRemote().sendText(ResoultUtil.error(ce.getCode(), ce.getMessage()));
                return;
            }
            //其他异常，打印控制台
            error.printStackTrace();
            session.getBasicRemote().sendText(ResoultUtil.error(exceEnum.UNKNOWN_ERROR));
        }catch (Exception e){
            error.printStackTrace();
        }
    }

}
