package com.bsav.siapm.mappers;

import com.bsav.siapm.entities.RequestDB;
import com.bsav.siapm.model.Request;

public class RequestMapper {

    public static Request toModel(RequestDB requestDB) {
        return new Request(
                requestDB.getId(),
                requestDB.getName(),
                requestDB.getSurname(),
                requestDB.getDocument(),
                requestDB.getEmail(),
                requestDB.getGraduate(),
                requestDB.getCode(),
                requestDB.getCertificate(),
                requestDB.getReceipt(),
                requestDB.getStatus()
        );
    }

    public static RequestDB toEntity(Request request) {
        return new RequestDB(
                request.getId(),
                request.getName(),
                request.getSurname(),
                request.getDocument(),
                request.getEmail(),
                request.getGraduate(),
                request.getCode(),
                request.getCertificate(),
                request.getReceipt(),
                request.getStatus()
        );
    }
}
