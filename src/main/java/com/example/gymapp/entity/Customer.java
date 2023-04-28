package com.example.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Customer {

    @Id
    @GeneratedValue
    int idPk_int;

    String name_txt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH-mm-ssZ")
    Date dateOfBirth_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH-mm-ssZ")
    Date anniversary_date;
    String mobile_txt;
    String email_txt;
    int feesToPay_int;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH-mm-ssZ")
    Date createdOn_dtm;
    boolean isActive_bool;

    public Customer(int idPk_int) {
        this.idPk_int = idPk_int;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gymDetailFkId_int")
    @ToString.Exclude
    private GymDetail gymDetail;
}
