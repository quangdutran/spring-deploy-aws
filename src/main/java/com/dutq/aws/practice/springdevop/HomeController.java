package com.dutq.aws.practice.springdevop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @Autowired
    private DeviceRepository deviceRepository;

    private final BigDecimal TWENTY = new BigDecimal(20);
    private final BigDecimal HUNDRED = new BigDecimal(100);
    
    @GetMapping("/devices/{id}")
    public ResponseEntity<DeviceDTO> getDeviceById(@PathVariable(value = "id") Integer deviceId) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"));
        return ResponseEntity.ok(convertToDTO(device));
    }

    @PostMapping("/devices")
    public ResponseEntity<DeviceDTO> createDevice(@RequestBody DeviceDTO device) {
        Device createdDevice = new Device(device.getName(), device.getDescription(), device.getPrice(), device.isOnSale());
        createdDevice = deviceRepository.save(createdDevice);
        device.setId(createdDevice.getId());
        return ResponseEntity.ok(device);
    }

    @DeleteMapping("/devices/{id}")
    public void deleteDeviceById(@PathVariable(value = "id") Integer deviceId) {
        deviceRepository.deleteById(deviceId);
    }

    private DeviceDTO convertToDTO(Device device) {
        return DeviceDTO.builder().id(device.getId())
                .description(device.getDescription())
                .name(device.getName())
                .price(device.isOnSale() ? device.getPrice().multiply(TWENTY).divide(HUNDRED) : device.getPrice())
                .onSale(device.isOnSale())
                .build();
    }


}
