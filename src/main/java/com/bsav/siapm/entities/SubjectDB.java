package com.bsav.siapm.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_SUBJECT;

@Data
@Entity
@Table(name = TABLE_SUBJECT, schema = DATABASE_SCHEMA)
public class SubjectDB implements Serializable {

    public static final String CODE = "code";
    public static final String PENSUM = "pensum";
    public static final String NAME = "name";
    public static final String SEMESTER = "semester";
    public static final String CREDITS = "credits";
    public static final String PREREQUISITES = "prerequisites";
    public static final String PRECREDITS = "precredits";
    public static final String ELECTIVE = "elective";

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = CODE)
    private String code;

    @Column(name = NAME)
    private String name;

    @Column(name = SEMESTER)
    private Integer semester;

    @Column(name = CREDITS)
    private Integer credits;

    @Column(name = PREREQUISITES)
    private String prerequisites;

    @Column(name = PRECREDITS)
    private Integer precredits;

    @Column(name = ELECTIVE)
    private Boolean elective;

    @EqualsAndHashCode.Exclude
    @JoinColumn(name = PENSUM, referencedColumnName = PensumDB.CODE)
    @ManyToOne
    private PensumDB pensum;

    @OneToMany(mappedBy = MicrocurriculumDB.ID)
    private List<MicrocurriculumDB> microcurriculums;

    @OneToMany(mappedBy = GroupDB.ID)
    private List<GroupDB> groups;

}

