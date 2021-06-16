package com.bsav.siapm.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_PENSUM;

@Entity
@Table(name = TABLE_PENSUM, schema = DATABASE_SCHEMA)
public class PensumDB implements Serializable {

    public static final String CAREER = "career";
    public static final String CODE = "code";
    public static final String ACTIVE = "active";

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = CODE)
    private String code;

    @Column(name = CAREER)
    private String career;

    @Column(name = ACTIVE)
    private Boolean active;

    @OneToMany(mappedBy = SubjectDB.PENSUM)
    private List<SubjectDB> subjects;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<SubjectDB> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDB> subjects) {
        this.subjects = subjects;
    }
}



