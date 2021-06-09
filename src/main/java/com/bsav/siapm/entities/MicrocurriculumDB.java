package com.bsav.siapm.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_MICROCURRICULUM;

@Data
@Entity
@Table(name = TABLE_MICROCURRICULUM, schema = DATABASE_SCHEMA)
public class MicrocurriculumDB implements Serializable {

    public static final String ID = "id";
    public static final String DOCUMENT = "document";
    public static final String CONTENT = "content";
    public static final String BIBLIOGRAPHY = "bibliography";
    public static final String SUBJECT = "subject";

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = ID)
    private Integer id;

    @Column(name = CONTENT)
    private String content;

    @Column(name = BIBLIOGRAPHY)
    private String bibliography;

    @Column(name = DOCUMENT)
    private String document;

    @EqualsAndHashCode.Exclude
    @JoinColumn(name = SUBJECT, referencedColumnName = SubjectDB.CODE)
    @ManyToOne
    private SubjectDB subject;

}

