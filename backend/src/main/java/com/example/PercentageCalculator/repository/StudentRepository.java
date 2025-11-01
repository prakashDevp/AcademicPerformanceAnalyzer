package com.example.PercentageCalculator.repository;

import com.example.PercentageCalculator.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
