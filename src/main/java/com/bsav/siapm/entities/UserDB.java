package com.bsav.siapm.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_USER;

@Entity
@Table(name = TABLE_USER, schema = DATABASE_SCHEMA)
public class UserDB implements Serializable {

    public static final String DOCUMENT = "document";
    public static final String EMAIL = "email";
    public static final String CODE = "code";
    public static final String PASSWORD = "password";
    public static final String CREATE_TIME = "create_time";
    public static final String ACTIVE = "active";
    public static final String ROLE = "role";


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
    @JoinColumn(name = ROLE, referencedColumnName = RoleDB.ID)
    @ManyToOne
    private RoleDB role;

    @OneToMany(mappedBy = GroupDB.ID)
    private List<GroupDB> groups;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public RoleDB getRole() {
        return role;
    }

    public void setRole(RoleDB role) {
        this.role = role;
    }

    public List<GroupDB> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDB> groups) {
        this.groups = groups;
    }
}
