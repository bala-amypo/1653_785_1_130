package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface WarrantyClaimRecordRepository {
    boolean existsBySerialNumberAndClaimReason(String s, String r);
    Optional<WarrantyClaimRecord> findById(Long id);
    List<WarrantyClaimRecord> findAll();
    List<WarrantyClaimRecord> findBySerialNumber(String serial);
    WarrantyClaimRecord save(WarrantyClaimRecord c);
}
