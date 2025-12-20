package com.example.demo.controller;

import com.example.demo.service.DeviceOwnershipService;
import com.example.demo.entity.DeviceOwnershipRecord;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    @Autowired
    private DeviceOwnershipService service;

    @PostMapping
    public DeviceOwnershipRecord addDevice(@RequestBody DeviceOwnershipRecord device) {
        return service.registerDevice(device);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }
}
