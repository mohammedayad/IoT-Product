package com.voice.iot.controller;

import com.voice.iot.model.DeviceDto;
import com.voice.iot.model.DevicesDto;
import com.voice.iot.model.ProblemDto;
import java.util.UUID;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ManageIoTTrackingDevicesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface ManageIoTTrackingDevicesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * @see ManageIoTTrackingDevicesApi#deleteDeviceConfigurationStatusById
     */
    default ResponseEntity<Void> deleteDeviceConfigurationStatusById(UUID deviceId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see ManageIoTTrackingDevicesApi#getAllDevices
     */
    default ResponseEntity<DevicesDto> getAllDevices(UUID status,
        Integer pageNumber,
        Integer pageSize) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"pagination\" : {    \"total\" : 1,    \"pageNumber\" : 0,    \"pageSize\" : 6  },  \"groups\" : [ {    \"simId\" : 5,    \"name\" : \"Samsara\",    \"temperature\" : \"75'C\",    \"description\" : \"description\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"status\" : \"READY\"  }, {    \"simId\" : 5,    \"name\" : \"Samsara\",    \"temperature\" : \"75'C\",    \"description\" : \"description\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"status\" : \"READY\"  } ]}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see ManageIoTTrackingDevicesApi#getDevicesAvailableForSale
     */
    default ResponseEntity<DevicesDto> getDevicesAvailableForSale(Integer pageNumber,
        Integer pageSize) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"pagination\" : {    \"total\" : 1,    \"pageNumber\" : 0,    \"pageSize\" : 6  },  \"groups\" : [ {    \"simId\" : 5,    \"name\" : \"Samsara\",    \"temperature\" : \"75'C\",    \"description\" : \"description\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"status\" : \"READY\"  }, {    \"simId\" : 5,    \"name\" : \"Samsara\",    \"temperature\" : \"75'C\",    \"description\" : \"description\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"status\" : \"READY\"  } ]}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see ManageIoTTrackingDevicesApi#updateDeviceConfigurationStatusById
     */
    default ResponseEntity<Void> updateDeviceConfigurationStatusById(UUID deviceId,
        DeviceDto deviceDto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
