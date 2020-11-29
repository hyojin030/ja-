package com.ja.jademo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;
    private String orz;
    private String work;
    private int class_num;
    private int student;
    private int edu_hour;
    private int volunteer;
    private int semester;
    private String inout2;

}
