package com.learning.ui.component.card;

import com.learning.ui.component.text.FlightMiniData;
import com.learning.ui.model.FlightInfo;
import com.learning.ui.model.FlightLegState;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightDataCard extends CustomCard {

    FlightMiniData cardModel;

    public FlightDataCard() {
        super(null, true);

        cardModel = new FlightMiniData();

        cardModel.getComponents().forEach(this::addContent);

        cardModel.updateData(getFlightInfo());
    }

    private FlightInfo getFlightInfo() {
        return FlightInfo.builder()
                .flightNumber(12341)
                .carrier("6E")
                .dateOfOrigin(LocalDate.now())
                .startStation("DEL")
                .endStation("MUB")
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

}