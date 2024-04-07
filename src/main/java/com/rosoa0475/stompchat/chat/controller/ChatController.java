package com.rosoa0475.stompchat.chat.controller;

import com.rosoa0475.stompchat.chat.DTO.ChatMessageDTO;
import com.rosoa0475.stompchat.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @MessageMapping("/{topicNum}") // 클라이언트에서 /send/{roomId}를 통해 컨트롤러의 @MessageMapping과 매핑된다
    @SendTo("/topic/{topicNum}") // 해당 문자열의 주소를 구독하고 있는 클라이언트에게 데이터 전송
    public ChatMessageDTO chat(/*@PathVariable과 같은 역할*/@DestinationVariable Long topicNum, @RequestBody ChatMessageDTO message){
        chatService.createChat(topicNum, message.getSender(), message.getMessage());
        return ChatMessageDTO.builder()
                .sender(message.getSender())
                .message(message.getMessage())
                .build();
    }
}
