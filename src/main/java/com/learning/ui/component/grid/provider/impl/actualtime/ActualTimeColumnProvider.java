package com.learning.ui.component.grid.provider.impl.actualtime;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.ActualTime;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class ActualTimeColumnProvider implements ColumnProvider<ActualTime> {
    @Override
    public Class<ActualTime> beanType() {
        return ActualTime.class;
    }

    @Override
    public Map<String, ValueProvider<ActualTime, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
            put("Flight No.", ActualTime::getFlightNumber);
            put("Carrier", ActualTime::getCarrier);
            put("Date Of Origin", ActualTime::getDateOfOrigin);
            put("Start Station", ActualTime::getStartStation);
            put("End Station", ActualTime::getEndStation);
            put("Schedule Start Time", ActualTime::getScheduleStartTime);
        }};
    }
}
