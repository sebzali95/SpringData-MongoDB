package com.example.customerservice.model;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

@Data
public class Customer {

    @Id
    private String id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private Integer age;
}
