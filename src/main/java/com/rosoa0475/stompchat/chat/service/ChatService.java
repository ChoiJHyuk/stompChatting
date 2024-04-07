package com.rosoa0475.stompchat.chat.service;

import com.rosoa0475.stompchat.chat.entity.Chat;
import com.rosoa0475.stompchat.chat.repository.ChatRepository;
import com.rosoa0475.stompchat.room.entity.ChatRoom;
import com.rosoa0475.stompchat.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final RoomRepository roomRepository;

    public void createChat(Long topicNum, String sender, String message) {
        ChatRoom room = roomRepository.findById(topicNum).get();
        chatRepository.save(Chat.builder()
                .room(room)
                .sender(sender)
                .message(message)
                .build());
    }
}
