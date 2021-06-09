package com.bsav.siapm.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Microcurriculum {
    private Integer id;
    private String content;
    private String bibliography;
    private String document;
}

