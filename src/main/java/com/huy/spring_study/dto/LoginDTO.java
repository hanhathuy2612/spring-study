package com.huy.spring_study.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.huy.spring_study.configuration.constant.ErrorMessage.PASSWORD_NOT_BLANK;
import static com.huy.spring_study.configuration.constant.ErrorMessage.USERNAME_NOT_BLANK;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NotBlank(message = USERNAME_NOT_BLANK)
    private String username;

    @NotBlank(message = PASSWORD_NOT_BLANK)
    private String password;
} 