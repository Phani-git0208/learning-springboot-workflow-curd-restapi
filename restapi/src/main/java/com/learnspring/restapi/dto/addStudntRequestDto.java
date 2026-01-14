package com.learnspring.restapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.Data;

@Data
public class addStudntRequestDto {

    @NotBlank(message = "name is required")
    private String name;

    @Email(message = "email should be valid")
    @NotBlank(message = "email is required")
    private String email;

    @Min(value = 0, message = "marks cannot be less than 0")
    @Max(value = 100, message = "marks cannot be more than 100")
    private int marks;
}

