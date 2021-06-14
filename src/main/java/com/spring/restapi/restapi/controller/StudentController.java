package com.spring.restapi.restapi.controller;

import com.spring.restapi.restapi.Student;
import com.spring.restapi.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET
    @RequestMapping("/students")
    public List<Student> getStudent() {
        return studentService.getStudents();
    }

    // GET students by id
    @RequestMapping("/students/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentsById(id);
    }

    // POST
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    // PUT
    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student, @PathVariable String id) {
        studentService.updateStudent(id, student);
    }

    // DELETE
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}
