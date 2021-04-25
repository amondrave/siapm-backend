package com.bsav.siapm.entities;

import com.bsav.siapm.utils.Constants;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static com.bsav.siapm.entities.DatabaseConstants.*;

@Data
@Entity
@Table(name = TABLE_ROLE, schema = DATABASE_SCHEMA)
public class Role implements Serializable {

    public static final String ID  = "id";
    public static final String ROLE  = "role";

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = ID)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = ROLE)
    private Constants.ERole role;

    @OneToMany(mappedBy = User.ROLE)
    private List<User> userList;

}
