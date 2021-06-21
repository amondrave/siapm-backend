package com.bsav.siapm.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_MICROCURRICULUM;

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
    private String id;

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

    public MicrocurriculumDB() {
    }

    public MicrocurriculumDB(String id, String content, String bibliography, String document) {
        this.id = id;
        this.content = content;
        this.bibliography = bibliography;
        this.document = document;
    }

    public static String getID() {
        return ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBibliography() {
        return bibliography;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public SubjectDB getSubject() {
        return subject;
    }

    public void setSubject(SubjectDB subject) {
        this.subject = subject;
    }
}

