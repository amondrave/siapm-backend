package com.bsav.siapm.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_GUIDELINE;

@Data
@Entity
@Table(name = TABLE_GUIDELINE, schema = DATABASE_SCHEMA)
public class GuidelineDB implements Serializable {

    public static final String ID = "id";
    public static final String DESCRIPTION = "description";
    public static final String DONE = "done";
    public static final String CREATE_TIME = "create_time";
    public static final String GROUP = "group";

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = ID)
    private Integer id;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = DONE)
    private Boolean done;

    @Column(name = CREATE_TIME)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @EqualsAndHashCode.Exclude
    @JoinColumn(name = GROUP, referencedColumnName = GroupDB.ID)
    @ManyToOne
    private GroupDB group;

}

