package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // GET all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // POST (Create or Update)
    public Student saveStudent(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
        if (student.getAge() <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        return studentRepository.save(student);
    }

    // DELETE student by ID
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // GET students by name
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }
}