package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import java.util.*;

public class DeviceOwnershipServiceImpl {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord record) {
        if (repo.existsBySerialNumber(record.getSerialNumber())) {
            throw new IllegalArgumentException("Duplicate serial");
        }
        return repo.save(record);
    }

    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord record = repo.findById(id).orElseThrow();
        record.setActive(active);
        return repo.save(record);
    }

    public Optional<DeviceOwnershipRecord> getBySerial(String serial) {
        return repo.findBySerialNumber(serial);
    }

    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }
}
