package com.bsav.siapm.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class ReturnMessage {
    private final int code;
    private String description;
}
