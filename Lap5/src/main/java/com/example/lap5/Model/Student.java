package com.example.lap5.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private final int id;
    private String name;
    private int age;
    private double degree ;
    private double GPA ;

}
