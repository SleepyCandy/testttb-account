package com.ttbtest.saleandservice.account.dto;

import lombok.Data;

@Data
public class ResponseFormat {

    String code = "200";
    String message = "SUCCESS";
    Object data;

    public ResponseFormat(Object data){
        this.data = data;
    }

}
