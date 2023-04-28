package com.example.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class GymTiming {

    @Id
    @GeneratedValue
    int idPk_int;

    Time openTime_date;
    Time closeTime_date;

    int dayCountFromMonday_int;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH-mm-ssZ")
    Date createdOn_date;
    boolean isActive_bool;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gymDetailFkId_int")
    private GymDetail gymDetail;
}
