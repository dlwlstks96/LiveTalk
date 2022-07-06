package com.webSocket;

import com.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import com.domain.Greeting;

@Controller
public class GreetingController {

    // @MessageMapping 애노테이션은 메시지가 /hello 대상으로 전송되면
    // greeting() 메소드가 호출되도록 한다.
    // 스레드가 1초 동안 절전 모드로 전환되도록 하여 처리 지연을 시뮬레이션한다.
    // 이는 클라이언트가 메시지를 보낸 후 서버가 메시지를 비동기식으로 처리해야 하는 만큼
    // 시간이 걸릴 수 있음을 보여주기 위한 것이다.
    //반환 값은 /topic/greetings에 지정된 모든 구독자에게 브로드 캐스트 된다.
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        //Thread.sleep(1000);
        return new Greeting("Hello, " +
                HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
