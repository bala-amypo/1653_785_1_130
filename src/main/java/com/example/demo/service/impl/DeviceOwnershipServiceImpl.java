package com.example.demo.service.impl;

import com.example.demo.service.DeviceOwnershipService;
import com.example.demo.entity.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        return repo.save(device);
    }

    public void updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord d = repo.findById(id).orElse(null);
        if (d != null) {
            d.setActive(active);
            repo.save(d);
        }
    }

    public DeviceOwnershipRecord getBySerial(String serialNumber) {
        return repo.findBySerialNumber(serialNumber).orElse(null);
    }

    public DeviceOwnershipRecord getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }
}
