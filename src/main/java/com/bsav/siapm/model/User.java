package com.bsav.siapm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_USER;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private String document;
    private String email;
    private String code;
    private String password;
    private Date createTime;
    private Boolean active;
    private Role role;
    private List<Group> groups;
}
