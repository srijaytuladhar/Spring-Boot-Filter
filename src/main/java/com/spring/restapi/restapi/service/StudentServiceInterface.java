package com.spring.restapi.restapi.service;

import com.spring.restapi.restapi.Student;

import java.util.Collection;

public interface StudentServiceInterface {
    public abstract void createStudent(Student student);
    public abstract void updateStudent(String id, Student student);
    public abstract void deleteStudent(String id);
    public abstract Collection<Student> getStudents();
    public abstract Student getStudentsById(String id);
}
