package com.bsav.siapm.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class Subject {
    private String code;
    private String name;
    private Integer semester;
    private Integer credits;
    private String prerequisites;
    private Integer precredits;
    private Boolean elective;
    private List<Microcurriculum> microcurriculums;
    private List<Group> groups;
}

