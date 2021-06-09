package com.bsav.siapm.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_REQUEST;

@Data
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
    private Integer id;

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

}
