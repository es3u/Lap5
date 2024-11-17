package com.example.trackersystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {

    private int id;
    private String title;
    private String description;
    private String status;
    private String companyName;


}
