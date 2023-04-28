package com.example.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class GymDetail {

    @Id
    @GeneratedValue
    int idPk_int;

    String name_txt;
    String address_txt;
    String longitude_txt;
    String latitude_txt;

    int feeAmount_int;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH-mm-ssZ")
    Date createdOn_date;

    boolean isActive_bool;

    @OneToMany(mappedBy = "gymDetail", fetch = FetchType.LAZY, orphanRemoval = false)
    List<GymTiming> gymTimings;

    @OneToMany(mappedBy = "gymDetail", fetch = FetchType.LAZY, orphanRemoval = false)
    List<Customer> customers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userFkId_int")
    private User user;
}
