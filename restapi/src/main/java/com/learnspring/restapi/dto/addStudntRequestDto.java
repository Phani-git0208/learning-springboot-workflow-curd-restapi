package com.learnspring.restapi.dto;

import lombok.Data;

@Data
public class addStudntRequestDto {
    private String name;
    private String email;
    private int marks;
}
