package com.learning.ui.component.grid.provider.impl.flightdelete;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.FlightDelete;
import com.learning.ui.model.FlightDelete;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class FlightDeleteColumnProvider implements ColumnProvider<FlightDelete> {
    @Override
    public Class<FlightDelete> beanType() {
        return FlightDelete.class;
    }

    @Override
    public Map<String, ValueProvider<FlightDelete, ?>> getHeaderAndValueProviders() {
        return  new LinkedHashMap<>() {{
            put("Flight No.", FlightDelete::getFlightNumber);
            put("Carrier", FlightDelete::getCarrier);
            put("Date Of Origin", FlightDelete::getDateOfOrigin);
            put("Start Station", FlightDelete::getStartStation);
            put("End Station", FlightDelete::getEndStation);
            put("Schedule Start Time", FlightDelete::getScheduleStartTime);
            put("Flight Delete",FlightDelete::getFlightDelete);
        }};
    }
}