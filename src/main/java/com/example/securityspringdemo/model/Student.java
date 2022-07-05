package com.example.securityspringdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Student {

    private final Integer studentId;
    private final String studentName;


}
