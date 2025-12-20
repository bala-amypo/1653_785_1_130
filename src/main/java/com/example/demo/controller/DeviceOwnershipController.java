package com.example.demo.controller;

import com.example.demo.service.DeviceOwnershipService;
import com.example.demo.entity.DeviceOwnershipRecord;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device Ownership")
public class DeviceOwnershipController {

    @Autowired
    private DeviceOwnershipService service;

    @PostMapping
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord device) {
        return service.registerDevice(device);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        service.updateDeviceStatus(id, active);
    }

    @GetMapping("/serial/{serialNumber}")
    public DeviceOwnershipRecord getBySerial(@PathVariable String serialNumber) {
        return service.getBySerial(serialNumber);
    }

    @GetMapping("/{id}")
    public DeviceOwnershipRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return service.getAllDevices();
    }
}
