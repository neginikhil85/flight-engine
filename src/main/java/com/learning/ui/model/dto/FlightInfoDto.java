package com.learning.ui.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FlightInfoDto {
    private int flightNumber;
    private String carrier;
    private LocalDate dateOfOrigin;
    private String startStation;
    private String endStation;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm a")
    private LocalDateTime scheduledStartTime;
}
