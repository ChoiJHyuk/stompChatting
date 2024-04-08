package com.rosoa0475.stompchat.room.controller;

import com.rosoa0475.stompchat.room.entity.ChatRoom;
import com.rosoa0475.stompchat.room.entity.RoomForm;
import com.rosoa0475.stompchat.room.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/list")
    @PreAuthorize("isAuthenticated()")
    public String list(Model model) {
        List<ChatRoom> rooms = roomService.getList();
        model.addAttribute("rooms", rooms);
        return "room/list";
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String create(RoomForm roomForm) {
        return "room/roomForm";
    }
    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String create(@Valid RoomForm roomForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "room/roomForm";
        }
        roomService.create(ChatRoom.builder()
                .name(roomForm.getName())
                .build());
        return "redirect:/room/list";
    }
}
