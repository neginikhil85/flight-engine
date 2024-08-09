package com.learning.ui.component.grid.provider.impl.doorclose;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.DoorClose;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class DoorCloseColumnProvider implements ColumnProvider<DoorClose> {
    @Override
    public Class<DoorClose> beanType() {
        return DoorClose.class;
    }

    @Override
    public Map<String, ValueProvider<DoorClose, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
            put("Flight No.", DoorClose::getFlightNumber);
            put("Carrier", DoorClose::getCarrier);
            put("Date Of Origin", DoorClose::getDateOfOrigin);
            put("Start Station", DoorClose::getStartStation);
            put("End Station", DoorClose::getEndStation);
            put("Schedule Start Time", DoorClose::getScheduleStartTime);
            put("Door Close Time", DoorClose::getDoorCloseTime);
        }};
    }
}