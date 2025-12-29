package com.example.demo.model;
import lombok.*;
import jakarta.persistence.Entity;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudAlertRecord {
    private Long id;
    private Long claimId;
    private String serialNumber;
    
    @Builder.Default
    private Boolean resolved = false;
}
