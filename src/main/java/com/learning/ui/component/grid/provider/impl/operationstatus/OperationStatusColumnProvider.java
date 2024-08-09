package com.learning.ui.component.grid.provider.impl.operationstatus;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.OperationStatus;
import com.learning.ui.model.OperationStatus;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class OperationStatusColumnProvider implements ColumnProvider<OperationStatus> {
    @Override
    public Class<OperationStatus> beanType() {
        return OperationStatus.class;
    }

    @Override
    public Map<String, ValueProvider<OperationStatus, ?>> getHeaderAndValueProviders() {
        return  new LinkedHashMap<>() {{
            put("Flight No.", OperationStatus::getFlightNumber);
            put("Carrier", OperationStatus::getCarrier);
            put("Date Of Origin", OperationStatus::getDateOfOrigin);
            put("Start Station", OperationStatus::getStartStation);
            put("End Station", OperationStatus::getEndStation);
            put("Schedule Start Time", OperationStatus::getScheduleStartTime);
        }};
    }
}
