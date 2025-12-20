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

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        return repo.save(device);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }
}
