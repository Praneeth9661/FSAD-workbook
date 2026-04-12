package com.fsad.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsad.backend.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
