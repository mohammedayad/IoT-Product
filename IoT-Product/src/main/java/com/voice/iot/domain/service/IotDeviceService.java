package com.voice.iot.domain.service;

import com.voice.iot.domain.enums.ConfigurationStatus;
import com.voice.iot.domain.enums.DeviceStatus;
import com.voice.iot.domain.exception.IotDeviceException;
import com.voice.iot.domain.mapper.IotDeviceMapper;
import com.voice.iot.domain.model.Device;
import com.voice.iot.domain.repository.IotDeviceRepository;
import com.voice.iot.model.DeviceDto;
import com.voice.iot.model.DevicesDto;
import com.voice.iot.model.PaginationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.voice.iot.domain.util.Constants.MAX_PAGE_SIZE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class IotDeviceService {
    private final IotDeviceRepository iotDeviceRepository;

    public IotDeviceService(IotDeviceRepository iotDeviceRepository) {
        this.iotDeviceRepository = iotDeviceRepository;
    }

    @Transactional(readOnly = true)
    public DevicesDto getIotDevicesByStatus(UUID status, Integer pageNumber, Integer pageSize) {
        validatePageNumberAndPageSize(pageNumber, pageSize);

        Specification<Device> notActiveDevices =
                (device, query, criteriaBuilder) ->
                        criteriaBuilder.equal(device.get("simCard").get("status"), DeviceStatus.WAITING_FOR_ACTIVATION);
        pageNumber=pageNumber-1;
        Page<Device> iotDevicePage = iotDeviceRepository.findAll(notActiveDevices, PageRequest.of(pageNumber, pageSize));
        return getDevicesDto(pageNumber, iotDevicePage);
    }

    @Transactional(readOnly = true)
    public DevicesDto getAllDevicesAvailableForSale(String body, Integer pageNumber, Integer pageSize) {

//        if (body == null || body.isEmpty()) {
//            throw new IotDeviceException(HttpStatus.BAD_REQUEST, "Sort Mechanism should has a value");
//        }
        validatePageNumberAndPageSize(pageNumber,pageSize);

        Specification<Device> configStatus =
                (iotDevice, query, criteriaBuilder) ->
                        criteriaBuilder.equal(iotDevice.get("configStatus"), ConfigurationStatus.READY);

        Specification<Device> status =
                (iotDevice, query, criteriaBuilder) ->
                        criteriaBuilder.equal(iotDevice.get("simCard").get("status"), DeviceStatus.ACTIVE);

        Specification<Device> temperature =
                (iotDevice, query, criteriaBuilder) ->
                        criteriaBuilder.between(iotDevice.get("temperature"), -25, 85);

        pageNumber = pageNumber-1;
        Page<Device> iotDevicePage = iotDeviceRepository
                .findAll(Specification.where(configStatus).and(temperature).and(status), PageRequest.of(pageNumber,pageSize,prepareSort(Optional.of(body))));
        return getDevicesDto(pageNumber, iotDevicePage);
    }

    private DevicesDto getDevicesDto(Integer pageNumber, Page<Device> iotDevicePage) {
        List<DeviceDto> iotDeviceDtoList = new ArrayList(10);
        if (!iotDevicePage.isEmpty()) {
            iotDevicePage.forEach(iotDevice -> iotDeviceDtoList.add(IotDeviceMapper.entityToDto(iotDevice)));
        }
        PaginationDto paginationDto = new PaginationDto();
        paginationDto.setPageNumber(pageNumber+1);
        paginationDto.setPageSize(iotDevicePage.getSize());
        paginationDto.setTotal(iotDevicePage.getTotalPages());
        DevicesDto trackingDevicesDto = new DevicesDto();
        trackingDevicesDto.setPagination(paginationDto);
        trackingDevicesDto.setGroups(iotDeviceDtoList);
        return trackingDevicesDto;
    }

    @Transactional
    public void updateIotDevice(UUID deviceId, DeviceDto updatedDevice) {

        Device iotDevice = iotDeviceRepository.findById(deviceId)
                .orElseThrow(() -> new IotDeviceException(HttpStatus.NOT_FOUND, "Iot Tracking Device is not found"));
//        trackingDevice.setId(deviceId);
        iotDevice.setConfigStatus(ConfigurationStatus.valueOf(updatedDevice.getStatus()));
        if(updatedDevice.getSimId()!= null){
            iotDevice.getSimCard().setStatus(DeviceStatus.valueOf(updatedDevice.getSimId().getStatus().name()));
        }
        iotDeviceRepository.save(iotDevice);
    }

    @Transactional
    public void deleteIotTrackingDevice(UUID deviceId) {

        boolean isExist = iotDeviceRepository.existsById(deviceId);
        if (!isExist) {
            throw new IotDeviceException(HttpStatus.NOT_FOUND, "Iot Tracking Device is not found");
        }
        iotDeviceRepository.deleteById(deviceId);
    }

    private void validatePageNumberAndPageSize(Integer pageNumber, Integer pageSize) {
        if (pageNumber != null && pageNumber < 1) {
            throw new IotDeviceException(HttpStatus.BAD_REQUEST, "Page number must be greater than or equal to 1");
        }

        if (pageSize != null && pageSize > MAX_PAGE_SIZE) {
            throw new IotDeviceException(HttpStatus.BAD_REQUEST, "Page size must be less than or equal to " + MAX_PAGE_SIZE);
        }
    }

    private Sort prepareSort(Optional<String> orderBy) {
        Sort sort = Sort.by("simCard.country").ascending();
        if (orderBy.isPresent()) {
            String[] orderBySplit = splitBySpace(orderBy.get());
            sort = orderBySplit.length == 1 ? Sort.by("simCard."+orderBySplit[0]).ascending()
                    : Sort.by("simCard."+orderBySplit[0]).descending();
        }
        return sort;
    }

    private  String[] splitBySpace(String word) {
        return word.trim().split("\\s+");
    }

}
