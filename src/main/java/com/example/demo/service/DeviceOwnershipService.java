package com.example.demo.service;

import com.example.demo.entity.DeviceOwnershipRecord;
import java.util.List;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);

    List<DeviceOwnershipRecord> getAllDevices();
}
