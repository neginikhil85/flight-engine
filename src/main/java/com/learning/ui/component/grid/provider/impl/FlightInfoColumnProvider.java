package com.learning.ui.component.grid.provider.impl;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.FlightInfo;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class FlightInfoColumnProvider implements ColumnProvider<FlightInfo> {

    @Override
    public Class<FlightInfo> beanType() {
        return FlightInfo.class;
    }

    @Override
    public Map<String, ValueProvider<FlightInfo, ?>> getHeaderAndValueProviders() {
        return new LinkedHashMap<>() {{
           put("Carrier", FlightInfo::getCarrier);
           put("Flight Number", FlightInfo::getFlightNumber);
           put("Date Of Origin", FlightInfo::getDateOfOrigin);
           put("Start Terminal", FlightInfo::getStartTerminal);
           put("End Terminal", FlightInfo::getEndTerminal);
           put("Schedule Start Time", FlightInfo::getScheduleStartTime);
        }};
    }
}
