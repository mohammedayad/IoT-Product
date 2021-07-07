package com.voice.iot.domain.model;

import com.voice.iot.domain.enums.ConfigurationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity(name = "iot_device")
public class Device {
    @Id
    @Column(name = "deviceid",nullable = false, updatable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "devicename",nullable = false)
    private String name;
    @Column
    private String description;

    @Column(nullable = false)
    private Double temperature;

    @Enumerated(EnumType.STRING)
    @Column(name = "configstatus",nullable = false)
    private ConfigurationStatus configStatus;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "simid")
    private SimCard simCard;
}
