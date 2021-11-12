package com.example.easyjava22.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Story {

    @Id @GeneratedValue
    private Long id;

    private String content;

}
