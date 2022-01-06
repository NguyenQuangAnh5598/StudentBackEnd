package com.example.studentbackend.controller;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin("*")
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> showList() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Optional<Student> studentOptional = studentService.findByID(student.getId());
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findByID(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(studentOptional.get(),HttpStatus.OK);
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findByID(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentOptional.get(),HttpStatus.OK);
    }
}
