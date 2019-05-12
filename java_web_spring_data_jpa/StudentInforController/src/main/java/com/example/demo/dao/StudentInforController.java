package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentInforController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students/")
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}/")
    public Student getStudentById(
            @PathVariable("id") Integer id
    ) {
        return studentRepository.findById(id).get();
    }

    @PostMapping("/students/")
    public String addStudent(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String sex
    ) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        studentRepository.save(student);
        return "Added";
    }

    @PutMapping("/students/{id}/")
    public String modifyStudent(
            @PathVariable("id") Integer id,
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String sex
    ) {
        Student student = studentRepository.findById(id).get();
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        studentRepository.save(student);
        return "Modified";
    }

    @DeleteMapping("/students/{id}/")
    public String deleteStudent(
            @PathVariable("id") Integer id
    ) {
        studentRepository.deleteById(id);
        return "Deleted";
    }
}
