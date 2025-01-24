package com.ttbtest.saleandservice.account.dto;


import lombok.Data;

import java.util.Date;

@Data
public class AccountDTO {
    private String firstname;
    private String lastname;
    private Date customerDate;
    private Boolean isVIP;
    private int statusCode;
}


