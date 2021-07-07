package com.voice.iot.domain.mapper;

import com.voice.iot.domain.model.Device;
import com.voice.iot.model.DeviceDto;
import com.voice.iot.model.SimCardDto;
import org.springframework.beans.BeanUtils;

public class IotDeviceMapper {
    private IotDeviceMapper() {
    }

    public static DeviceDto entityToDto(Device iotDevice) {
        DeviceDto iotDeviceDto = new DeviceDto();
        SimCardDto simCardDto = new SimCardDto();
        BeanUtils.copyProperties(iotDevice.getSimCard(), simCardDto);
        simCardDto.setStatus(SimCardDto.StatusEnum.valueOf(iotDevice.getSimCard().getStatus().name()));
        BeanUtils.copyProperties(iotDevice, iotDeviceDto);
        iotDeviceDto.setSimId(simCardDto);
        iotDeviceDto.setStatus(iotDevice.getConfigStatus().name());
        iotDeviceDto.setTemperature(iotDevice.getTemperature()+"'C");
        return iotDeviceDto;
    }
}
