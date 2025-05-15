package com.huy.spring_study.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.huy.spring_study.configuration.constant.ErrorMessage.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    @NotBlank(message = USERNAME_NOT_BLANK)
    @Size(min = 3, max = 50, message = USERNAME_MIN_MAX_LENGTH)
    private String username;

    @NotBlank(message = PASSWORD_NOT_BLANK)
    @Size(min = 6, message = PASSWORD_MIN_LENGTH)
    private String password;

    @NotBlank(message = EMAIL_NOT_BLANK)
    @Email(message = EMAIL_NOT_VALID)
    private String email;

    @NotBlank(message = FULL_NAME_NOT_BLANK)
    private String fullName;
} 