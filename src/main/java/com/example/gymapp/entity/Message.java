package com.example.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Message {

    @Id
    @GeneratedValue
    int idPk_int;
    int triggerId_int;
    int sentToCustomerId_int;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH-mm-ssZ")
    Date sentOn_dtm;
    String smsContent_txt;
    boolean isSent_bool;

}
