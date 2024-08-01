package com.learning.ui.model;

import com.learning.ui.component.text.LabeledValue;
import com.learning.ui.enums.FlightDataFields;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.learning.ui.enums.FlightDataFields.*;

public class FlightCardModel {
    private LabeledValue carrier = new LabeledValue(CARRIER.getLabel());
    private LabeledValue flightNumber = new LabeledValue(FLIGHT_NUMBER.getLabel());
    private LabeledValue startStation = new LabeledValue(START_STATION.getLabel());
    private LabeledValue endStation = new LabeledValue(END_STATION.getLabel());
    private LabeledValue scheduledStartTime = new LabeledValue(SCHEDULED_START_TIME.getLabel());
    private LabeledValue operationalStatus = new LabeledValue(OPERATIONAL_STATUS.getLabel());
    private LabeledValue dateOfOrigin = new LabeledValue(DATE_OF_ORIGIN.getLabel());
    private LabeledValue startTerminal = new LabeledValue(START_TERMINAL.getLabel());
    private LabeledValue endTerminal = new LabeledValue(END_TERMINAL.getLabel());
    private LabeledValue cancellationCode = new LabeledValue(CANCELLATION_CODE.getLabel());
    private LabeledValue startGate = new LabeledValue(START_GATE.getLabel());
    private LabeledValue endGate = new LabeledValue(END_GATE.getLabel());
    private LabeledValue startStand = new LabeledValue(START_STAND.getLabel());
    private LabeledValue startTimeOffset = new LabeledValue(START_TIME_OFFSET.getLabel());
    private LabeledValue endTimeOffset = new LabeledValue(END_TIME_OFFSET.getLabel());

    public Map<FlightDataFields, LabeledValue> getDataMap() {
        return new LinkedHashMap<>() {{
            put(CARRIER, carrier);
            put(FLIGHT_NUMBER, flightNumber);
            put(START_STATION, startStation);
            put(END_STATION, endStation);
            put(SCHEDULED_START_TIME, scheduledStartTime);
            put(OPERATIONAL_STATUS, operationalStatus);
            /*put(DATE_OF_ORIGIN, dateOfOrigin);
            put(START_TERMINAL, startTerminal);
            put(END_TERMINAL, endTerminal);
            put(CANCELLATION_CODE, cancellationCode);
            put(START_GATE, startGate);
            put(END_GATE, endGate);
            put(START_STAND, startStand);
            put(START_TIME_OFFSET, startTimeOffset);
            put(END_TIME_OFFSET, endTimeOffset);*/
        }};
    }
}
