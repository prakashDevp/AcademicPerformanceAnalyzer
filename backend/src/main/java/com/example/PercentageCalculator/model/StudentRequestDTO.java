package com.example.PercentageCalculator.model;

import lombok.Data;
import java.util.List;

@Data
public class StudentRequestDTO {
    private String username;
    private String level;
    private List<Double> marks;
}
