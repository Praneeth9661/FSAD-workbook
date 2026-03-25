package com.klu.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.restapi.entity.Course;
import com.klu.restapi.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course getCourseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Course updateCourse(Long id, Course course) {
        Course existing = repository.findById(id).orElse(null);
        if(existing != null){
            existing.setTitle(course.getTitle());
            existing.setDuration(course.getDuration());
            existing.setFee(course.getFee());
            return repository.save(existing);
        }
        return null;
    }

    public String deleteCourse(Long id) {
        repository.deleteById(id);
        return "Course deleted";
    }

    public Course searchByTitle(String title) {
        return repository.findByTitle(title);
    }
}
