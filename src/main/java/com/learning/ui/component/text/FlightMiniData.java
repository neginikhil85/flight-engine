package com.learning.ui.component.text;

import com.learning.ui.enums.FlightDataFields;
import com.learning.ui.model.FlightCardModel;
import com.learning.ui.model.FlightInfo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class FlightMiniData extends VerticalLayout {

    Map<FlightDataFields, LabeledValue> dataMap = new FlightCardModel().getDataMap();
    @Getter
    Collection<Component> components = new ArrayList<>();

    public FlightMiniData() {
        this.setMargin(true);

        HorizontalLayout carrierAndNumber = getHorizontalGroup(FlightDataFields.CARRIER, FlightDataFields.FLIGHT_NUMBER);
        HorizontalLayout stations = getHorizontalGroup(FlightDataFields.START_STATION, FlightDataFields.END_STATION);
        LabeledValue dateAndTime = dataMap.get(FlightDataFields.SCHEDULED_START_TIME);
        LabeledValue status = dataMap.get(FlightDataFields.OPERATIONAL_STATUS);


        carrierAndNumber.addClassName("card-div-details");
        stations.addClassName("card-div-details");
        dateAndTime.addClassName("card-div-details");
        status.addClassName("card-div-details");

        components.add(carrierAndNumber);
        components.add(stations);
        components.add(dateAndTime);
        components.add(status);

        add(carrierAndNumber, stations, dateAndTime, status);
    }

    private HorizontalLayout getHorizontalGroup(FlightDataFields field1, FlightDataFields field2) {
        return new HorizontalLayout(dataMap.get(field1), dataMap.get(field2));
    }

    private HorizontalLayout getHorizontalGroup(FlightDataFields field1, VaadinIcon icon, FlightDataFields field2) {
        return new HorizontalLayout(dataMap.get(field1), icon.create(), dataMap.get(field2));
    }

    public void updateData(FlightInfo flightInfo) {
        setValueIfPresent(flightInfo, FlightInfo::getCarrier, FlightDataFields.CARRIER);
        setValueIfPresent(flightInfo, FlightInfo::getFlightNumber, FlightDataFields.FLIGHT_NUMBER);
        setValueIfPresent(flightInfo, FlightInfo::getStartStation, FlightDataFields.START_STATION);
        setValueIfPresent(flightInfo, FlightInfo::getEndStation, FlightDataFields.END_STATION);
        setValueIfPresent(flightInfo, FlightInfo::getScheduleStartTime, FlightDataFields.SCHEDULED_START_TIME);
    }

    public <T> void setValueIfPresent(T obj, Function<T, ?> function, FlightDataFields field) {
        Optional.of(obj).map(function)
                .ifPresent(value -> dataMap.get(field).setValue(String.valueOf(value)));
    }

}
