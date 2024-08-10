package com.learning.ui.component.grid.provider.impl.landingtime;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.grid.LandingTime;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class LandingTimeColumnProvider implements ColumnProvider<LandingTime> {
    @Override
    public Class<LandingTime> beanType() {
        return LandingTime.class;
    }

    @Override
    public Map<String, ValueProvider<LandingTime, ?>> getHeaderAndValueProviders() {
        return  new LinkedHashMap<>() {{
            put("Flight No.",LandingTime::getFlightNumber);
            put("Carrier",LandingTime::getCarrier);
            put("Date Of Origin",LandingTime::getDateOfOrigin);
            put("Start Station",LandingTime::getStartStation);
            put("End Station",LandingTime::getEndStation);
            put("Schedule Start Time",LandingTime::getScheduledStartTime);
        }};
    }
}
