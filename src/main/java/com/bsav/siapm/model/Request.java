package com.bsav.siapm.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_REQUEST;

@Data
@AllArgsConstructor
public class Request {
    private Integer id;
    private String name;
    private String surname;
    private String document;
    private String email;
    private Boolean graduate;
    private String code;
    private String certificate;
    private String receipt;
}
