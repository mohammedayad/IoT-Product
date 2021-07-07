package com.voice.iot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.voiceIOTProducts.base-path:/api/voice/iot-product-service}")
public class ManageIoTTrackingDevicesApiController implements ManageIoTTrackingDevicesApi {

    private final ManageIoTTrackingDevicesApiDelegate delegate;

    public ManageIoTTrackingDevicesApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ManageIoTTrackingDevicesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ManageIoTTrackingDevicesApiDelegate() {});
    }

    @Override
    public ManageIoTTrackingDevicesApiDelegate getDelegate() {
        return delegate;
    }

}
