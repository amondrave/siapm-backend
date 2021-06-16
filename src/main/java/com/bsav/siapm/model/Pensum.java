package com.bsav.siapm.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Pensum {
    private String code;
    private String career;
    private Boolean active;
    private List<Semester> semesters;
}

