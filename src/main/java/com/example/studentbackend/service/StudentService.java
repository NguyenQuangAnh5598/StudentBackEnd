package com.example.studentbackend.service;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> findByID(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepo.deleteById(id);
    }
}
