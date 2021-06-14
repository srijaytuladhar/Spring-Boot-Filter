package com.spring.restapi.restapi.service;

import com.spring.restapi.restapi.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service        // business logic
public class StudentService implements StudentServiceInterface {

    private List<Student> students = new ArrayList<>( Arrays.asList(
            new Student("1", "Ramesh Shrestha", 21, "rameshshrestha@abcd.com"),
            new Student("2", "Tom Gurung", 22, "tommygurung@abcd.com"),
            new Student("3", "Selina Rai", 23, "selinarai@abcd.com"),
            new Student("4", "Prakash Bhattarai", 21, "prakashbhattarai@abcd.com")
    ));

    @Override
    public void createStudent(Student student) {
        students.add(student);
        System.out.println("Student created successfully!!");
    }

    @Override
    public void updateStudent(String id, Student student) {
        for (int i=0; i<students.size(); i++) {
            Student s = students.get(i);
            if (s.getId().equals(id)) {
                students.set(i, student);
            }
        }

        System.out.println("Student with id: " +id+ " updated successfully!!");
    }

    @Override
    public void deleteStudent(String id) {
        students.removeIf(s->s.getId().equals(id));

        System.out.println("Student with id: " +id+ " deleted successfully!!");
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public Student getStudentsById(String id) {
        return students.stream().filter(s->s.getId().equals(id)).findFirst().get();
    }
}
