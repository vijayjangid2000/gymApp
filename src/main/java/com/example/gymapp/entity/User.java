package com.example.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class User {

    @Id
    @GeneratedValue
    int idPk_int;

    String name_txt;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    Date dateOfBirth_date;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    Date anniversary_date;

    @Column(unique = true, length = 20)
    String mobile_txt;
    String email_txt;
    int feesToPay_int;

    String password;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    Date createdOn_dtm;
    boolean isActive_bool;

    /*@OneToMany(mappedBy = "user")
    List<GymDetail> gymDetails;

    @OneToMany(mappedBy = "user")
    List<Payment> payments;*/

}
