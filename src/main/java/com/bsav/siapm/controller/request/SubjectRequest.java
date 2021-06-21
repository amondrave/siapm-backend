package com.bsav.siapm.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SubjectRequest {
    @NotBlank
    private String code;
    @NotBlank
    private String name;
    @NotBlank
    private Integer credits;
    @NotBlank
    private Integer semester;
    @NotBlank
    private String content;
    @NotBlank
    private String bibliography;
    private String document;
}

