package com.rosoa0475.stompchat.chat.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatMessageDTO {
    @JsonProperty("sender")
    private String sender;
    @JsonProperty("message")
    private String message;

}
