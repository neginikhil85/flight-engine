package com.learning.ui.component.grid.provider.impl.takeofftime;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.grid.TakeOffTime;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class TakeOffTimeColumnProvider implements ColumnProvider<TakeOffTime> {
    @Override
    public Class<TakeOffTime> beanType() {
        return TakeOffTime.class;
    }

    @Override
    public Map<String, ValueProvider<TakeOffTime, ?>> getHeaderAndValueProviders() {
        return  new LinkedHashMap<>() {{
            put("Flight No.", TakeOffTime::getFlightNumber);
            put("Carrier", TakeOffTime::getCarrier);
            put("Date Of Origin", TakeOffTime::getDateOfOrigin);
            put("Start Station", TakeOffTime::getStartStation);
            put("End Station", TakeOffTime::getEndStation);
            put("Scheduled Start Time", TakeOffTime::getScheduledStartTime);
        }};
    }
}
