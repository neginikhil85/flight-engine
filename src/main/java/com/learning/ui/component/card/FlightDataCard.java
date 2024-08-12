package com.learning.ui.component.card;

import com.learning.ui.component.text.FlightMiniData;
import com.learning.ui.model.dto.FlightInfoDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FlightDataCard extends CustomCard {

    FlightMiniData cardModel;

    public FlightDataCard() {
        super(null, true);

        cardModel = new FlightMiniData();

        cardModel.getComponents().forEach(this::addContent);

        cardModel.updateData(getFlightInfo());
    }

    private FlightInfoDto getFlightInfo() {
        return FlightInfoDto.builder()
                .flightNumber(12341)
                .carrier("6E")
                .dateOfOrigin(LocalDate.now())
                .startStation("DEL")
                .endStation("MUB")
                .scheduledStartTime(LocalDateTime.now())
                .build();
    }

}