package com.learning.ui.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class DoorClose extends FlightInfo {
    private ActualTime currentActualTimes;
    private ActualTime previousActualTimes;
}
