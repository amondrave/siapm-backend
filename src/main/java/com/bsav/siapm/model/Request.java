package com.bsav.siapm.model;

import com.bsav.siapm.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

import static com.bsav.siapm.entities.DatabaseConstants.DATABASE_SCHEMA;
import static com.bsav.siapm.entities.DatabaseConstants.TABLE_REQUEST;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private String id;
    private String name;
    private String surname;
    private String document;
    private String email;
    private Boolean graduate;
    private String code;
    private String certificate;
    private String receipt;
    private Constants.Status status;
}
