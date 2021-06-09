package com.bsav.siapm.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Guideline {
    private Integer id;
    private String description;
    private Boolean done;
    private Date createTime;
}

