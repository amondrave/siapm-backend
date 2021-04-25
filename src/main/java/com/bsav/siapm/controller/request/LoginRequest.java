package com.bsav.siapm.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank
    private String document;

    @NotBlank
    private String password;
}
