package com.rosoa0475.stompchat.chat.controller;

import com.rosoa0475.stompchat.chat.DTO.ChatMessageDTO;
import com.rosoa0475.stompchat.chat.entity.Chat;
import com.rosoa0475.stompchat.chat.service.ChatService;
import com.rosoa0475.stompchat.room.entity.ChatRoom;
import com.rosoa0475.stompchat.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;
    private final RoomService roomService;
    @GetMapping("/chatRoom")
    public String chatRoom(@RequestParam(name = "roomId") Long roomId, Model model, Principal principal) {
        ChatRoom chatRoom = roomService.getOne(roomId);
        model.addAttribute("chatRoom", chatRoom);
        model.addAttribute("name", principal.getName());
        return "room/chatRoom";
    }

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
