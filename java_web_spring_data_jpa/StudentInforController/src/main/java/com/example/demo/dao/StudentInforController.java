package com.example.demo.dao;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students/")
public class StudentInforController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/all/")
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/find/")
    public Student getStudentById(
            @RequestParam Integer id
    ) {
        return studentRepository.findById(id).get();
    }

    @PostMapping("/add/")
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

    @PostMapping("/modify/")
    public String modifyStudent(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String sex
    ) {
        Student student = studentRepository.findById(id).get();
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        return "Modified";
    }

    @DeleteMapping("/delete/")
    public String deleteStudent(
            @RequestParam Integer id
    ) {
        studentRepository.deleteById(id);
        return "Deleted";
    }
}
