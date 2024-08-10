package com.learning.ui.component.grid.provider.impl.flightreturn;

import com.learning.ui.component.grid.provider.ColumnProvider;
import com.learning.ui.model.grid.FlightReturn;
import com.vaadin.flow.function.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
public class FlightReturnColumnProvider implements ColumnProvider<FlightReturn> {
    @Override
    public Class<FlightReturn> beanType() {
        return FlightReturn.class;
    }

    @Override
    public Map<String, ValueProvider<FlightReturn, ?>> getHeaderAndValueProviders() {
        return  new LinkedHashMap<>() {{
            put("Flight No.", FlightReturn::getFlightNumber);
            //put("Carrier", FlightReturn::getCarrier);
            put("Date Of Origin", FlightReturn::getDateOfOrigin);
            put("Start Station", FlightReturn::getStartStation);
            put("End Station", FlightReturn::getEndStation);
            put("Scheduled Start Time", FlightReturn::getScheduledStartTime);
        }};
    }
}
