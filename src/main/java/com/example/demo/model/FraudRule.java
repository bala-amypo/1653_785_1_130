package com.example.demo.model;
import lombok.*;
import jakarta.persistence.*;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudRule {
      @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String ruleCode;
    private String ruleType;
    private String description;
    private Boolean active;
}
