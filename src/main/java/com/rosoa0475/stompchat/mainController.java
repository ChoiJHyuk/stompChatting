package com.rosoa0475.stompchat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/")
    public String home(){
        return "defaultContent";
    }
}
