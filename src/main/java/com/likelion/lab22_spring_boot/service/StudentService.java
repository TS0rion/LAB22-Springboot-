package com.likelion.lab22_spring_boot.service;

import java.util.List;

import com.likelion.lab22_spring_boot.dto.StudentDto;

public interface StudentService {
    StudentDto create(StudentDto dto);

    StudentDto update(String id, StudentDto dto);

    StudentDto getById(String id);

    List<StudentDto> getAll();

    void delete(String id);
}
