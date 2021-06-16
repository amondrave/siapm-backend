package com.bsav.siapm.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_GROUP;

@Entity
@Table(name = TABLE_GROUP, schema = DATABASE_SCHEMA)
public class GroupDB implements Serializable {

    public static final String ID = "id";
    public static final String PERIOD = "period";
    public static final String PROFESSOR = "professor";
    public static final String SUBJECT = "subject";

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = ID)
    private String id;

    @Column(name = PERIOD)
    private String period;

    @OneToOne
    @JoinColumn(name = PROFESSOR, nullable = false)
    private UserDB professor;

    @EqualsAndHashCode.Exclude
    @JoinColumn(name = SUBJECT, referencedColumnName = SubjectDB.CODE)
    @ManyToOne
    private SubjectDB subject;

    @OneToMany(mappedBy = GuidelineDB.ID)
    private List<GuidelineDB> guidelines;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public UserDB getProfessor() {
        return professor;
    }

    public void setProfessor(UserDB professor) {
        this.professor = professor;
    }

    public SubjectDB getSubject() {
        return subject;
    }

    public void setSubject(SubjectDB subject) {
        this.subject = subject;
    }

    public List<GuidelineDB> getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(List<GuidelineDB> guidelines) {
        this.guidelines = guidelines;
    }
}
