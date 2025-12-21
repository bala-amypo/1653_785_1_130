package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.WarrantyClaimRecord;
import java.util.List;

public interface WarrantyClaimRecordRepository
        extends JpaRepository<WarrantyClaimRecord, Long> {

    List<WarrantyClaimRecord> findBySerialNumber(String serialNumber);
}
