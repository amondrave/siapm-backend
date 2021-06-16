package com.bsav.siapm.entities;

import com.bsav.siapm.utils.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_ROLE;

@Entity
@Table(name = TABLE_ROLE, schema = DATABASE_SCHEMA)
public class RoleDB implements Serializable {

    public static final String ID = "id";
    public static final String ROLE = "role";

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = ID)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = ROLE)
    private Constants.ERole role;

    @OneToMany(mappedBy = UserDB.ROLE)
    private List<UserDB> userList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Constants.ERole getRole() {
        return role;
    }

    public void setRole(Constants.ERole role) {
        this.role = role;
    }

    public List<UserDB> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDB> userList) {
        this.userList = userList;
    }
}
