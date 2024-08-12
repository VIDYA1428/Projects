package com.example.CRUD_OPERATIONS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUD_OPERATIONS.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
