package com.learning.ui.component.grid.provider.impl.gatechange;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.GateChange;
import com.learning.ui.model.GateChange;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class GateChangeColumnProvider implements ColumnProvider<GateChange> {
    @Override
    public Class<GateChange> beanType() {
        return GateChange.class;
    }

    @Override
    public Map<String, ValueProvider<GateChange, ?>> getHeaderAndValueProviders() {
        return  new LinkedHashMap<>() {{
            put("Flight No.", GateChange::getFlightNumber);
            put("Carrier", GateChange::getCarrier);
            put("Date Of Origin", GateChange::getDateOfOrigin);
            put("Start Station", GateChange::getStartStation);
            put("End Station", GateChange::getEndStation);
            put("Schedule Start Time", GateChange::getScheduleStartTime);
        }};
    }
}
