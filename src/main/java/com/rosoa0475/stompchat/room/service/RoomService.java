package com.rosoa0475.stompchat.room.service;

import com.rosoa0475.stompchat.room.entity.ChatRoom;
import com.rosoa0475.stompchat.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<ChatRoom> getList() {
        return roomRepository.findAll();
    }

    public void create(ChatRoom room) {
        roomRepository.save(room);
    }

    public ChatRoom getOne(Long roomId) {
        return roomRepository.findById(roomId).get();
    }
}
