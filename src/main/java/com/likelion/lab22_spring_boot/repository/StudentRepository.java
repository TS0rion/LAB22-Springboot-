package com.likelion.lab22_spring_boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.likelion.lab22_spring_boot.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
