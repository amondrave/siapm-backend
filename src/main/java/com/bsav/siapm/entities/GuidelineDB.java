package com.bsav.siapm.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_GUIDELINE;

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

    public static String getID() {
        return ID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public GroupDB getGroup() {
        return group;
    }

    public void setGroup(GroupDB group) {
        this.group = group;
    }
}

