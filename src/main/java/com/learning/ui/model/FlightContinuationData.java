package com.learning.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightContinuationData extends FlightInfo {
    private String suffix;
    private String scheduledEndTime;
    private String startTimeOffset;
    private String endTimeOffset;
    private String seqNumber;
}
