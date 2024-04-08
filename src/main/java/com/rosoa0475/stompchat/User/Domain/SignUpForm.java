package com.rosoa0475.stompchat.User.Domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpForm {
    @NotEmpty(message = "아이디를 입력해주세요.")
    @Size(min = 4, max = 16)
    private String username;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인을 입력해주세요.")
    private String password2;
}
