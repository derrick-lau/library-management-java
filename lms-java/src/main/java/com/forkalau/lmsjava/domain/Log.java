package com.forkalau.lmsjava.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Log {

    @Id
    @GeneratedValue
    private Long id;
    private String message;

}
