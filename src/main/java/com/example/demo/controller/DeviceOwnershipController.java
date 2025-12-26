package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device Ownership")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    // POST /api/devices
    @PostMapping
    public DeviceOwnershipRecord registerDevice(
            @RequestBody DeviceOwnershipRecord record) {
        return service.registerDevice(record);
    }

    // PUT /api/devices/{id}/status
    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateDeviceStatus(id, active);
    }

    // GET /api/devices/serial/{serialNumber}
    @GetMapping("/serial/{serialNumber}")
    public Optional<DeviceOwnershipRecord> getBySerial(
            @PathVariable String serialNumber) {
        return service.getBySerial(serialNumber);
    }

    // GET /api/devices/{id}
    @GetMapping("/{id}")
    public Optional<DeviceOwnershipRecord> getById(
            @PathVariable Long id) {
        return service.getAllDevices()
                .stream()
                .filter(d -> id.equals(d.getId()))
                .findFirst();
    }

    // GET /api/devices
    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return service.getAllDevices();
    }
}
