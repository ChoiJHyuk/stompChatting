package com.rosoa0475.stompchat.room.entity;


import com.rosoa0475.stompchat.chat.entity.Chat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "room" , cascade = CascadeType.REMOVE)
    private List<Chat> chats;

    private String name;

}