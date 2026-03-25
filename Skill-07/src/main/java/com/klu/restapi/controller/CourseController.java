package com.klu.restapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.klu.restapi.entity.Course;
import com.klu.restapi.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return ResponseEntity.ok(service.saveCourse(course));
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        Course course = service.getCourseById(id);
        if(course == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id,@RequestBody Course course){
        Course updated = service.updateCourse(id, course);
        if(updated == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteCourse(id));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<Course> searchCourse(@PathVariable String title){
        Course course = service.searchByTitle(title);
        if(course == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(course);
    }
}
