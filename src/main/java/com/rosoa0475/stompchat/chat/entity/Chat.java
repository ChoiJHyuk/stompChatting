package com.rosoa0475.stompchat.chat.entity;

import com.rosoa0475.stompchat.room.entity.ChatRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    private ChatRoom room;

    @Column
    private String sender;

    @Column
    private String message;

    private LocalDateTime sendDate = LocalDateTime.now();
}
