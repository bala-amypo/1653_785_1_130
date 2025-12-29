package com.example.demo.model;
import lombok.*;
import jakarta.persistence.Entity;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyClaimRecord {
    private Long id;
    private String serialNumber;
    private String claimReason;

    @Builder.Default
    private String status = "PENDING";
}
