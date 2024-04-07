package com.rosoa0475.stompchat.room.repository;

import com.rosoa0475.stompchat.room.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<ChatRoom, Long> {
}
