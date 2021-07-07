package com.voice.iot.domain.service;

import com.voice.iot.domain.exception.IotDeviceException;
import com.voice.iot.domain.mapper.IotDeviceMapper;
import com.voice.iot.domain.model.Device;
import com.voice.iot.domain.repository.IotDeviceRepository;
import com.voice.iot.model.DeviceDto;
import com.voice.iot.model.DevicesDto;
import com.voice.iot.model.SimCardDto;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import static org.mockito.ArgumentMatchers.any;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class IotTrackingDevicesServiceTest {

    @InjectMocks
    IotDeviceService trackingDevicesService;

    @Mock
    IotDeviceRepository trackingDevicesRepository;

    @Test
    void testGetAvailableTrackingDevicesForSale() {
        int pageNumber = 1, pageSize = 10;
        Device trackingDevice = new Device();
       DeviceDto trackingDeviceDto = new DeviceDto();
        Page<Device> trackingDevicePage = new PageImpl<>(Collections.singletonList(trackingDevice));
        when(trackingDevicesRepository.findAll(any(Specification.class), any(PageRequest.class))).thenReturn(trackingDevicePage);
        try (MockedStatic<IotDeviceMapper> mapper = Mockito.mockStatic(IotDeviceMapper  .class)) {
            mapper.when(() -> IotDeviceMapper.entityToDto(any(Device.class)))
                    .thenReturn(trackingDeviceDto);
            DevicesDto trackingDevicesDto = trackingDevicesService.getAllDevicesAvailableForSale("country",pageNumber, pageSize);
            Assertions.assertEquals(trackingDevicePage.getTotalPages(),
                    trackingDevicesDto.getPagination().getTotal());
            Assertions.assertEquals(pageNumber, trackingDevicesDto.getPagination().getPageNumber());
            Assertions.assertEquals(trackingDevicePage.getSize(), trackingDevicesDto.getPagination().getPageSize());
            Assertions.assertEquals(trackingDevicePage.getContent().size(),
                    trackingDevicesDto.getGroups().size());
        }
    }

    @Test
    void testGetAvailableTrackingDevicesForSale_emptyBody() {
        int pageNumber = -1, pageSize = 10;
        IotDeviceException exception = assertThrows(IotDeviceException.class,
                () -> trackingDevicesService.getAllDevicesAvailableForSale("",pageNumber, pageSize));
        assertNotNull(exception);
    }

    @Test
    void testGetAvailableTrackingDevicesForSale_InvalidPageNumber() {
        int pageNumber = -1, pageSize = 10;
        IotDeviceException exception = assertThrows(IotDeviceException.class,
                () -> trackingDevicesService.getAllDevicesAvailableForSale("country",pageNumber, pageSize));
        assertNotNull(exception);
    }

    @Test
    void testGetAvailableTrackingDevicesForSale_InvalidPageSize() {
        int pageNumber = 1, pageSize = 1000;
        IotDeviceException thrown = assertThrows(IotDeviceException.class,
                () -> trackingDevicesService.getAllDevicesAvailableForSale("country",pageNumber, pageSize));
        assertNotNull(thrown);
    }

    @Test
    void testGetAvailableTrackingDevicesForSale_EmptyResult() {
        int pageNumber = 1, pageSize = 10;
        Page<Device> trackingDevicePage = new PageImpl<>(new ArrayList<>());
        when(trackingDevicesRepository.findAll(any(Specification.class), any(PageRequest.class))).thenReturn(trackingDevicePage);
        DevicesDto trackingDevicesDto = trackingDevicesService.getIotDevicesByStatus(UUID.randomUUID(),pageNumber, pageSize);
        Assertions.assertEquals(trackingDevicePage.getTotalPages(),
                trackingDevicesDto.getPagination().getTotal());
        Assertions.assertEquals(pageNumber, trackingDevicesDto.getPagination().getPageNumber());
        Assertions.assertEquals(trackingDevicePage.getSize(), trackingDevicesDto.getPagination().getPageSize());
        Assertions.assertEquals(trackingDevicePage.getContent().size(),
                trackingDevicesDto.getGroups().size());
    }


    /**
     * Method: getAllActiveTrackingDevices(Integer pageNumber, Integer pageSize)
     */
    @Test
    void testGetAllActiveTrackingDevices() {
        int pageNumber = 1, pageSize = 10;
        Device trackingDevice = new Device();
        DeviceDto trackingDeviceDto = new DeviceDto();
        Page<Device> trackingDevicePage = new PageImpl<>(Collections.singletonList(trackingDevice));
        when(trackingDevicesRepository.findAll(any(Specification.class), any(PageRequest.class))).thenReturn(trackingDevicePage);
        try (MockedStatic<IotDeviceMapper> mapper = Mockito.mockStatic(IotDeviceMapper  .class)) {
            mapper.when(() -> IotDeviceMapper.entityToDto(any(Device.class)))
                    .thenReturn(trackingDeviceDto);
            DevicesDto trackingDevicesDto = trackingDevicesService.getIotDevicesByStatus(UUID.randomUUID(),pageNumber, pageSize);
            Assertions.assertEquals(trackingDevicePage.getTotalPages(),
                    trackingDevicesDto.getPagination().getTotal());
            Assertions.assertEquals(pageNumber, trackingDevicesDto.getPagination().getPageNumber());
            Assertions.assertEquals(trackingDevicePage.getSize(), trackingDevicesDto.getPagination().getPageSize());
            Assertions.assertEquals(trackingDevicePage.getContent().size(),
                    trackingDevicesDto.getGroups().size());

        }
    }

    @Test
    void testGetAllActiveTrackingDevices_InvalidPageNumber() {
        int pageNumber = -1, pageSize = 10;
        IotDeviceException thrown = assertThrows(IotDeviceException.class,
                () -> trackingDevicesService.getIotDevicesByStatus(UUID.randomUUID(),pageNumber, pageSize));
        assertNotNull(thrown);
    }

    @Test
    void testGetAllActiveTrackingDevices_InvalidPageSize() {
        int pageNumber = 1, pageSize = 1000;
        IotDeviceException thrown = assertThrows(IotDeviceException.class,
                () -> trackingDevicesService.getIotDevicesByStatus(UUID.randomUUID(),pageNumber, pageSize));
        assertNotNull(thrown);
    }

    @Test
    void testGetAllActiveTrackingDevices_EmptyResult() {
        int pageNumber = 1, pageSize = 10;
        Page<Device> trackingDevicePage = new PageImpl<>(new ArrayList<>());
        when(trackingDevicesRepository.findAll(any(Specification.class), any(PageRequest.class))).thenReturn(trackingDevicePage);
        DevicesDto trackingDevicesDto = trackingDevicesService.getIotDevicesByStatus(UUID.randomUUID(),pageNumber, pageSize);
        Assertions.assertEquals(trackingDevicePage.getTotalPages(),
                trackingDevicesDto.getPagination().getTotal());
        Assertions.assertEquals(pageNumber, trackingDevicesDto.getPagination().getPageNumber());
        Assertions.assertEquals(trackingDevicePage.getSize(), trackingDevicesDto.getPagination().getPageSize());
        Assertions.assertEquals(trackingDevicePage.getContent().size(),
                trackingDevicesDto.getGroups().size());
    }

    /**
     * Method: updateTrackingDevice(UUID deviceId, DeviceDto trackingDeviceDto)
     */
    @Test
    void testUpdateTrackingDevice() {
        UUID deviceId = UUID.randomUUID();
        DeviceDto trackingDeviceDto = new DeviceDto();
        trackingDeviceDto.setStatus("READY");
        when(trackingDevicesRepository.findById(deviceId)).thenReturn(Optional.of(new Device()));
        assertThatCode(() -> trackingDevicesService.updateIotDevice(deviceId, trackingDeviceDto))
                .doesNotThrowAnyException();
    }

    @Test
    void testUpdateTrackingDevice_InvalidDeviceId() {
        UUID deviceId = UUID.randomUUID();
        DeviceDto trackingDeviceDto = new DeviceDto();
        when(trackingDevicesRepository.findById(deviceId)).thenReturn(Optional.empty());
        IotDeviceException exception = assertThrows(IotDeviceException.class,
                () -> trackingDevicesService.updateIotDevice(deviceId, trackingDeviceDto));
        assertNotNull(exception);
    }

    /**
     * Method: deleteTrackingDevice(UUID deviceId)
     */
    @Test
    void testDeleteTrackingDevice() {
        UUID deviceId = UUID.randomUUID();
        when(trackingDevicesRepository.existsById(deviceId)).thenReturn(true);
        assertThatCode(() -> trackingDevicesService.deleteIotTrackingDevice(deviceId))
                .doesNotThrowAnyException();
    }

    @Test
    void testDeleteTrackingDevice_InvalidDeviceId() {
        UUID deviceId = UUID.randomUUID();
        when(trackingDevicesRepository.existsById(deviceId)).thenReturn(false);
        IotDeviceException exception = assertThrows(IotDeviceException.class,
                () -> trackingDevicesService.deleteIotTrackingDevice(deviceId));
        assertNotNull(exception);
    }
}
