package cn.coding.com.exchangerates.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "customer_db")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private String customerName;

    private String phoneNo;

    private Double exchangeAmount;

    private Double rate;

    private String cashOut;

    private String cashIn;

    private String deposit;

    private String withdraw;

    private String kbzPay;

    private String waveMoney;

    private String topUp;

    private String mobileBanking;

    private String accountTransfer;

    private String visaCard;

    private String loan;

    private Date date;

    private String description;
}
