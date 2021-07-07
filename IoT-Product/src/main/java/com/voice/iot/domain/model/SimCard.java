package com.voice.iot.domain.model;

import com.voice.iot.domain.enums.DeviceStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "sim_card")
public class SimCard {

    @Id
    @Column(name="simid",nullable = false, updatable = false)
    @GeneratedValue
    private UUID simId;

    @Column(name="operatorcode",nullable = false)
    private String operatorCode;


    @Column(nullable = false)
    private String country;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceStatus status;


    @OneToOne(fetch = FetchType.LAZY,mappedBy = "simCard")
    private Device iotDevice;
}
