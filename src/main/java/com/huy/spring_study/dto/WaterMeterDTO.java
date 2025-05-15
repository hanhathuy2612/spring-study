package com.huy.spring_study.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class WaterMeterDTO implements Serializable {
    private Long id;
    private String meterName;
    private double cubicMeters;
    private String description;
    private String firebasePath;
}
