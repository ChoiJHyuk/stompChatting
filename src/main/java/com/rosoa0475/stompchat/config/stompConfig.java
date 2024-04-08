package com.rosoa0475.stompchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // stomp를 사용하여 socket 통신을 하겠다는 어노테이션
public class stompConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp") // 클라이언트에서 소켓을 생성할 때 여기에 정의한 문자열로 해야 함
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS(); // 클라이언트와 연결은 SockJS로 함을 명시
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // topic의 prefix 이름 설정 앞으로 이 topic 이름을 가지고 pub/sub을 거침
        registry.setApplicationDestinationPrefixes("/send"); // 클라이언트에서 보낸 메세지를 받을 떄의 prefix
    }
}
