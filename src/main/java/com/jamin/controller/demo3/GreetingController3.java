package com.jamin.controller.demo3;

import com.jamin.login.Authentication;
import com.jamin.model.Greeting;
import com.jamin.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * Description:
 * Author: 杰明Jamin
 * Date: 2017/11/4 11:49
 */
@Controller
public class GreetingController3 {

    private final SimpMessagingTemplate messagingTemplate;

    /*
     * 实例化Controller的时候，注入SimpMessagingTemplate
     */
    @Autowired
    public GreetingController3(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/demo3/hello/{destUsername}")
    @SendToUser("/demo3/greetings")
    public Greeting greeting(@DestinationVariable String destUsername, HelloMessage message, StompHeaderAccessor headerAccessor) throws Exception {

        Authentication user = (Authentication) headerAccessor.getUser();

        String sessionId = headerAccessor.getSessionId();

        Greeting greeting = new Greeting(user.getName(), "sessionId: " + sessionId + ", message: " + message.getMessage());

        /*
         * 对目标进行发送信息
         */
        messagingTemplate.convertAndSendToUser(destUsername, "/demo3/greetings", greeting);

        return new Greeting("系统", new Date().toString() + "消息已被推送。");
    }

}
