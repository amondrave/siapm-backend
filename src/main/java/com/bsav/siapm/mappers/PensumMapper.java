package com.bsav.siapm.mappers;

import com.bsav.siapm.entities.PensumDB;
import com.bsav.siapm.model.Pensum;
import com.bsav.siapm.model.Semester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PensumMapper {

    public static Pensum toEntity(PensumDB pensumDB) {
        return new Pensum(
                pensumDB.getCode(),
                pensumDB.getCareer(),
                pensumDB.getActive(),
                getSemesters(pensumDB)
        );
    }

    private static List<Semester> getSemesters(PensumDB pensumDB) {
        Semester[] semesters = new Semester[10];
        pensumDB.getSubjects().forEach(
                subject -> {
                    int valor = subject.getSemester();
                    if (semesters[valor] == null){
                        semesters[valor] = new Semester(valor, new ArrayList<>());
                        semesters[valor].getSubjects().add(SubjectMapper.toEntity(subject));
                    }
                }
        );
        return Arrays.stream(semesters).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
