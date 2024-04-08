package com.rosoa0475.stompchat.room.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RoomForm {
    @NotEmpty(message = "방 이름을 적어주세요")
    private String name;
}
