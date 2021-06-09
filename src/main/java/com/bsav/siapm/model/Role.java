package com.bsav.siapm.model;

import com.bsav.siapm.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Role {
    private Integer id;
    private Constants.ERole role;
}
