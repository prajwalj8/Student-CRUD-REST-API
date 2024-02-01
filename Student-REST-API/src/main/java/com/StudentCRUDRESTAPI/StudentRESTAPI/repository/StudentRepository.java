package com.StudentCRUDRESTAPI.StudentRESTAPI.repository;

import com.StudentCRUDRESTAPI.StudentRESTAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
