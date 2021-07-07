package com.voice.iot.domain.repository;

import com.voice.iot.domain.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IotDeviceRepository extends JpaRepository<Device, UUID>, JpaSpecificationExecutor<Device> {
}
