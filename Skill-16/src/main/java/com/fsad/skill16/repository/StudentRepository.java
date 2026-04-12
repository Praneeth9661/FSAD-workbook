package com.fsad.skill16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fsad.skill16.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
