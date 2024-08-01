package com.learning.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class DelayData extends FlightInfo {
    private String delayLimit;
    private String remarks;
    private int total;
    private List<DelayItem> delays;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DelayItem {
        private String time;
        private String reason;
        private String delayNumber;
        private boolean isRootCause;
        private String remark;
    }

}
