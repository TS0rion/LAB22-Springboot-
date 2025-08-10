package com.likelion.lab22_spring_boot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StudentDto {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
}
