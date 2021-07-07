package com.voice.iot.resources.rest.controller;

import com.voice.iot.controller.ManageIoTTrackingDevicesApiDelegate;
import com.voice.iot.domain.service.IotDeviceService;
import com.voice.iot.model.DeviceDto;
import com.voice.iot.model.DevicesDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@Slf4j
public class IotDeviceController implements ManageIoTTrackingDevicesApiDelegate {

    private final IotDeviceService iotDeviceService;

    public IotDeviceController(IotDeviceService iotDeviceService) {
        this.iotDeviceService = iotDeviceService;
    }

    @Override
    public ResponseEntity<DevicesDto> getAllDevices(UUID status, Integer pageNumber, Integer pageSize) {
        log.info("getAllDevices");
        DevicesDto iotDevicesDto = iotDeviceService.getIotDevicesByStatus(status,pageNumber, pageSize);
        return ResponseEntity.ok(iotDevicesDto);
    }

    @Override
    public ResponseEntity<DevicesDto> getDevicesAvailableForSale(Integer pageNumber, Integer pageSize) {
        log.info("getDevicesAvailableForSale");
        DevicesDto iotDevicesDto = iotDeviceService.getAllDevicesAvailableForSale("",pageNumber,pageSize);
        return ResponseEntity.ok(iotDevicesDto);
    }

    @Override
    public ResponseEntity<Void> updateDeviceConfigurationStatusById(UUID deviceId, DeviceDto deviceDto) {
        log.info("updateDeviceConfigurationStatusById");
        iotDeviceService.updateIotDevice(deviceId, deviceDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @Override
    public ResponseEntity<Void> deleteDeviceConfigurationStatusById(UUID deviceId) {
        log.info("updateDeviceConfigurationStatusById");
        iotDeviceService.deleteIotTrackingDevice(deviceId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
