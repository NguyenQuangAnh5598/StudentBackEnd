package com.example.studentbackend.service;

import com.example.studentbackend.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAll();

    Optional<Student> findByID(Long id);

    Student save(Student city);

    void remove(Long id);
}
