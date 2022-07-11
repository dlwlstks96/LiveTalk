package com.controller;

import com.websocket.SubmitMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import com.domain.Message;

@Controller
public class MessageController {

    // @MessageMapping 애노테이션은 메시지가 /client 대상으로 전송되면
    // sendMessage() 메소드가 호출되도록 한다.
    //반환 값은 /topic/submitMessages에 지정된 모든 구독자에게 브로드 캐스트 된다.
    @MessageMapping("/client")
    @SendTo("/topic/submitMessages")
    public Message sendMessage(SubmitMessage message) throws Exception {
        return new Message(HtmlUtils.htmlEscape(message.getMessage()));
    }

}
