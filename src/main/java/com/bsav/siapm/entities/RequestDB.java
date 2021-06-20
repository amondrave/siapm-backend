package com.bsav.siapm.entities;

import javax.persistence.*;
import java.io.Serializable;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_REQUEST;

@Entity
@Table(name = TABLE_REQUEST, schema = DATABASE_SCHEMA)
public class RequestDB implements Serializable {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String DOCUMENT = "document";
    public static final String EMAIL = "email";
    public static final String GRADUATE = "graduate";
    public static final String CODE = "code";
    public static final String CERTIFICATE = "certificate";
    public static final String RECEIPT = "receipt";

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = ID)
    private String id;

    @Column(name = NAME)
    private String name;

    @Column(name = SURNAME)
    private String surname;

    @Column(name = DOCUMENT)
    private String document;

    @Column(name = EMAIL)
    private String email;

    @Column(name = GRADUATE)
    private Boolean graduate;

    @Column(name = CODE)
    private String code;

    @Column(name = CERTIFICATE)
    private String certificate;

    @Column(name = RECEIPT)
    private String receipt;

    public RequestDB() {
    }

    public RequestDB(String id, String name, String surname, String document, String email, Boolean graduate, String code, String certificate, String receipt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.email = email;
        this.graduate = graduate;
        this.code = code;
        this.certificate = certificate;
        this.receipt = receipt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGraduate() {
        return graduate;
    }

    public void setGraduate(Boolean graduate) {
        this.graduate = graduate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }
}
