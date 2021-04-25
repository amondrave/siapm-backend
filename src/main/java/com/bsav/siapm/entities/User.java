package com.bsav.siapm.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_USER;

@Data
@Entity
@Table(name = TABLE_USER, schema = DATABASE_SCHEMA)
public class User implements Serializable {

    public static final String DOCUMENT  = "document";
    public static final String EMAIL  = "email";
    public static final String CODE  = "code";
    public static final String PASSWORD  = "password";
    public static final String CREATE_TIME  = "create_time";
    public static final String ACTIVE  = "active";
    public static final String ROLE  = "role";


    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = DOCUMENT)
    private String document;

    @Column(name = EMAIL)
    private String email;

    @Column(name = CODE)
    private String code;

    @Column(name = PASSWORD)
    private String password;

    @Column(name = CREATE_TIME)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = ACTIVE)
    private Boolean active;

    @EqualsAndHashCode.Exclude
    @JoinColumn(name = ROLE, referencedColumnName = Role.ID)
    @ManyToOne
    private Role role;


}
