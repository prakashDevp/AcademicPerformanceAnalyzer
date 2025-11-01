package com.example.PercentageCalculator.controller;

import com.example.PercentageCalculator.model.StudentRequestDTO;
import com.example.PercentageCalculator.model.Result;
import com.example.PercentageCalculator.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/calculate")
    public Result calculate(@RequestBody StudentRequestDTO dto) {
        return studentService.saveStudentAndResult(dto);
    }

    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}
