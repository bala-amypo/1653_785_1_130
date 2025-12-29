package com.example.demo.repository;
import com.example.demo.model.WarrantyClaimRecord;
import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface WarrantyClaimRecordRepository extends JpaRepository<WarrantyClaimRecord,Long> {
    boolean existsBySerialNumberAndClaimReason(String serial, String reason);
    Optional<WarrantyClaimRecord> findById(Long id);
    List<WarrantyClaimRecord> findBySerialNumber(String serial);
    List<WarrantyClaimRecord> findAll();
    WarrantyClaimRecord save(WarrantyClaimRecord record);
}
