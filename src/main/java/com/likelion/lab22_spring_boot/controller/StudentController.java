package com.likelion.lab22_spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.likelion.lab22_spring_boot.dto.StudentDto;
import com.likelion.lab22_spring_boot.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService StudentService;

    @GetMapping
    public List<StudentDto> getAll() {
        return StudentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable String id) {
        return StudentService.getById(id);
    }

    @PostMapping
    public StudentDto create(@RequestBody StudentDto dto) {
        return StudentService.create(dto);
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable String id, @RequestBody StudentDto dto) {
        return StudentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        StudentService.delete(id);
    }
}
