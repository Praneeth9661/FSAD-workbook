package com.klu.controller;

import com.klu.model.Course;
import com.klu.service.CourseService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        if(course.getCourseId() <= 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid Course ID");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addCourse(course));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Course c = service.getCourseById(id);

        if(c == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course Not Found");

        return ResponseEntity.ok(c);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestBody Course course) {

        Course updated = service.updateCourse(id, course);

        if(updated == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course Not Found for Update");

        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        Course deleted = service.deleteCourse(id);

        if(deleted == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course Not Found for Delete");

        return ResponseEntity.ok("Course Deleted Successfully");
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<?> search(@PathVariable String title) {

        List<Course> list = service.searchByTitle(title);

        if(list.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No Courses Found");

        return ResponseEntity.ok(list);
    }
}