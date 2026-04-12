package com.fsad.skill16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fsad.skill16.entity.Student;
import com.fsad.skill16.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student save(Student student) {
        return repo.save(student);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Student update(Long id, Student student) {
        Student s = repo.findById(id).orElse(null);
        if (s != null) {
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            s.setCourse(student.getCourse());
            return repo.save(s);
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
