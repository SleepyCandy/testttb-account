package com.ttbtest.saleandservice.account.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "account_number", nullable = false, length = 20)
    private String accountNumber;

    @Column(name = "account_type", nullable = false, length = 20)
    private String accountType;

    @Column(name = "balance", nullable = false, precision = 15, scale = 2)
    private BigDecimal balance;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "status_code", nullable = false)
    private Integer statusCode; // สถานะบัญชี เช่น 1 = Active, 2 = Suspended, 3 = Closed



}