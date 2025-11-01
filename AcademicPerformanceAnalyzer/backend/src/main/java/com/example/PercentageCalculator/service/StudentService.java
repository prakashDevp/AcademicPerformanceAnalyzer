package com.example.PercentageCalculator.service;

import com.example.PercentageCalculator.dto.*; // not used but placeholder
import com.example.PercentageCalculator.model.*;
import com.example.PercentageCalculator.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ResultRepository resultRepository;

    public double calculatePercentage(List<Double> marks) {
        double total = marks.stream().mapToDouble(Double::doubleValue).sum();
        return total / marks.size();
    }

    public Result saveStudentAndResult(StudentRequestDTO dto) {
        Student student = Student.builder()
                .username(dto.getUsername())
                .level(dto.getLevel())
                .build();

        double percentage = calculatePercentage(dto.getMarks());
        String marksString = dto.getMarks().toString().replace("[", "").replace("]", "");

        Result result = Result.builder()
                .percentage(percentage)
                .marks(marksString)
                .student(student)
                .build();

        studentRepository.save(student);
        Result saved = resultRepository.save(result);

        return saved;
    }
}
