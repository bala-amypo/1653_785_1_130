package com.example.demo.model;
import lombok.*;
import java.time.LocalDate;
import jakarta.persistence.*;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceOwnershipRecord {
  @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private String ownerName;
    private String ownerEmail;
    private LocalDate warrantyExpiration;
    private Boolean active;
}
