package com.likelion.lab22_spring_boot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.likelion.lab22_spring_boot.dto.StudentDto;
import com.likelion.lab22_spring_boot.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);

    Student toEntity(StudentDto dto);

    List<StudentDto> toDtoList(List<Student> students);

    void updateEntityFromDto(StudentDto dto, @MappingTarget Student entity);
}
