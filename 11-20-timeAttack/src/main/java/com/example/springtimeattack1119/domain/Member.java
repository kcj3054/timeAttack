package com.example.springtimeattack1119.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class Member {

    @Id
    @GeneratedValue
    Long id;

    String title;
    String content;

}
