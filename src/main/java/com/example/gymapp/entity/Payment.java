package com.example.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue
    int idPk_int;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    Date fromDate_date;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    Date toDate_date;

    int amount_int;
    String paymentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="customerFkId_int")
    private User user;

}
