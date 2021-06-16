package com.bsav.siapm.mappers;

import com.bsav.siapm.entities.GroupDB;
import com.bsav.siapm.model.Group;

import java.util.ArrayList;

public class GroupMapper {
    public static Group toEntity(GroupDB groupDB) {
        return new Group(
                groupDB.getId(),
                groupDB.getPeriod(),
                new ArrayList<>()
        );
    }
}
