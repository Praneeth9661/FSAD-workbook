package com.klu.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.restapi.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByTitle(String title);

}
