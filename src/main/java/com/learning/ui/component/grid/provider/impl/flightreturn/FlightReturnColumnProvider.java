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
            put("Return Number", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getReturnNumber()));
            put("Aircraft", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getAircraft()));
            put("In Block Fuel", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getInBlockFuel()));
            put("Schedule Status", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getScheduleStatus()));
            put("Estimated In Block", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getEstimatedTimes().getInBlock()));
            put("Estimated Off Block", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getEstimatedTimes().getOffBlock()));
            put("Estimated Take Off", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getEstimatedTimes().getTakeOffTime()));
            put("Estimated Landing", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getEstimatedTimes().getLandingTime()));
            put("Actual In Block", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getActualTimes().getInBlock()));
            put("Actual Off Block", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getActualTimes().getOffBlock()));
            put("Actual Take Off", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getActualTimes().getTakeOffTime()));
            put("Actual Landing", safeValueProvider(flightReturn -> flightReturn.getReturnAtom().getActualTimes().getLandingTime()));
        }};
    }
}
