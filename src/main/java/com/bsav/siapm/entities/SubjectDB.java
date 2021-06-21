package com.bsav.siapm.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_SUBJECT;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private PensumDB pensum;

    @OneToMany(mappedBy = MicrocurriculumDB.ID)
    private List<MicrocurriculumDB> microcurriculums;

    @OneToMany(mappedBy = GroupDB.ID)
    private List<GroupDB> groups;

    public SubjectDB() {
    }

    public SubjectDB(String code, String name, Integer semester, Integer credits) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public Integer getPrecredits() {
        return precredits;
    }

    public void setPrecredits(Integer precredits) {
        this.precredits = precredits;
    }

    public Boolean getElective() {
        return elective;
    }

    public void setElective(Boolean elective) {
        this.elective = elective;
    }

    public PensumDB getPensum() {
        return pensum;
    }

    public void setPensum(PensumDB pensum) {
        this.pensum = pensum;
    }

    public List<MicrocurriculumDB> getMicrocurriculums() {
        return microcurriculums;
    }

    public void setMicrocurriculums(List<MicrocurriculumDB> microcurriculums) {
        this.microcurriculums = microcurriculums;
    }

    public List<GroupDB> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDB> groups) {
        this.groups = groups;
    }
}

