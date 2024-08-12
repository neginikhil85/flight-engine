package com.learning.ui.component.grid.provider.impl.diversion;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.grid.DiversionData;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class DiversionColumnProvider implements ColumnProvider<DiversionData> {
    @Override
    public Class<DiversionData> beanType() {
        return DiversionData.class;
    }

    @Override
    public Map<String, ValueProvider<DiversionData, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
            put("Flight No.", DiversionData::getFlightNumber);
            put("Date Of Origin", DiversionData::getDateOfOrigin);
            put("Start Station", DiversionData::getStartStation);
            put("End Station", DiversionData::getEndStation);
            put("Scheduled Start Time", DiversionData::getScheduledStartTime);
            put("Flight Status", DiversionData::getFlightStatus);
            put("Effective Arrival Station", DiversionData::getEffectiveArrivalStation);
            put("Diversion Reason", DiversionData::getDiversionCode);
            put("Estimated In Block", DiversionData::getEstimatedInBlock);
            put("Registration", DiversionData::getRegistration);
            put("Continuation Flight No.", diversionData -> diversionData.getContinuationLeg().getFlightNumber());
            put("Continuation Date Of Origin", diversionData -> diversionData.getContinuationLeg().getDateOfOrigin());
            put("Continuation Start Station", diversionData -> diversionData.getContinuationLeg().getStartStation());
            put("Continuation end Station", diversionData -> diversionData.getContinuationLeg().getEndStation());
            put("Continuation Scheduled Start Time", diversionData -> diversionData.getContinuationLeg().getScheduledStartTime());
            put("Continuation suffix", diversionData -> diversionData.getContinuationLeg().getSuffix());
            put("Continuation scheduled End Time", diversionData -> diversionData.getContinuationLeg().getScheduledEndTime());
            put("Continuation Start Time Offset", diversionData -> diversionData.getContinuationLeg().getStartTimeOffset());
            put("Continuation End Time Offset", diversionData -> diversionData.getContinuationLeg().getEndTimeOffset());
            put("Continuation Seq No.", diversionData -> diversionData.getContinuationLeg().getSeqNumber());
        }};
    }
}
