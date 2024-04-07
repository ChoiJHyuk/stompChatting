package com.rosoa0475.stompchat.chat.repository;

import com.rosoa0475.stompchat.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
