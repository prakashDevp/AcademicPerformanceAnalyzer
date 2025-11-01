package com.example.PercentageCalculator.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "results")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double percentage;

    @Column(length = 1000)
    private String marks;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
