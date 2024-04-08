package com.rosoa0475.stompchat.User.Controller;

import com.rosoa0475.stompchat.User.Domain.SignUpForm;
import com.rosoa0475.stompchat.User.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/signup")
    public String create(SignUpForm signUpForm){
        return "user/signup";
    }

    @PostMapping("/signup")
    public String create(@Valid SignUpForm signUpForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "user/signup";
        }
        if (!signUpForm.getPassword1().equals(signUpForm.getPassword2())) {
            bindingResult.rejectValue("password2", "differentPassword",
                    "패스워드가 일치하지 않습니다.");
            return "user/signup";
        }
        this.userService.saveUser(signUpForm.getUsername(), signUpForm.getPassword1());
        return "redirect:/";
    }


}
