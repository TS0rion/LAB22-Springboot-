package com.likelion.lab22_spring_boot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.likelion.lab22_spring_boot.dto.StudentDto;
import com.likelion.lab22_spring_boot.exception.ResourceNotFoundException;
import com.likelion.lab22_spring_boot.mapper.StudentMapper;
import com.likelion.lab22_spring_boot.repository.StudentRepository;
import com.likelion.lab22_spring_boot.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    @Override
    public StudentDto create(StudentDto dto) {
        return mapper.toDto(studentRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public StudentDto update(String id, StudentDto dto) {
        return studentRepository.findById(id)
                .map(existing -> {
                    mapper.updateEntityFromDto(dto, existing);
                    return mapper.toDto(studentRepository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
    }

    @Override
    public StudentDto getById(String id) {
        return studentRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
    }

    @Override
    public List<StudentDto> getAll() {
        return mapper.toDtoList(studentRepository.findAll());
    }

    @Override
    public void delete(String id) {
        studentRepository.findById(id)
                .ifPresentOrElse(
                        studentRepository::delete,
                        () -> {
                            throw new ResourceNotFoundException("Not found: " + id);
                        });
    }

}
