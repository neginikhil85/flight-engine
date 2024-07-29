package com.learning.ui.component.card;

import com.learning.ui.enums.FlightDataFields;
import com.learning.ui.model.FlightCardModel;
import com.learning.ui.model.FlightInfo;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.Function;

public class FlightDataCard extends CustomCard {

    FlightCardModel cardModel;

    public FlightDataCard() {
        super("Flight Data", true);

        cardModel = new FlightCardModel();
        addLabeledValue(cardModel.getDataMap().values());

        updateData(getFlightInfo());
    }

    private FlightInfo getFlightInfo() {
        return FlightInfo.builder()
                .flightNumber(1234)
                .carrier("6E")
                .dateOfOrigin(LocalDate.now())
                .startTerminal("Delhi")
                .endTerminal("Mumbai")
                .scheduleStartTime(getFormattedDateTime())
                .build();
    }

    private String getFormattedDateTime() {
        // Define the formatter with the desired pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format the date and time
        return now.format(formatter);
    }

    public void updateData(FlightInfo flightInfo) {
        setValueIfPresent(flightInfo, FlightInfo::getFlightNumber, FlightDataFields.FLIGHT_NUMBER);
        setValueIfPresent(flightInfo, FlightInfo::getCarrier, FlightDataFields.CARRIER);
        setValueIfPresent(flightInfo, FlightInfo::getDateOfOrigin, FlightDataFields.DATE_OF_ORIGIN);
        setValueIfPresent(flightInfo, FlightInfo::getStartTerminal, FlightDataFields.START_TERMINAL);
        setValueIfPresent(flightInfo, FlightInfo::getEndTerminal, FlightDataFields.END_TERMINAL);
        setValueIfPresent(flightInfo, FlightInfo::getScheduleStartTime, FlightDataFields.SCHEDULED_START_TIME);
    }

    public <T> void setValueIfPresent(T obj, Function<T, ?> fun, FlightDataFields field) {
        Optional.of(obj).map(fun).ifPresent(value ->
                cardModel.getDataMap().get(field).setValue(String.valueOf(value))
        );
    }

}