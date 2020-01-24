package com.forkalau.lmsjava.security.Payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "Username cannot be blank")
    private String password;
}
