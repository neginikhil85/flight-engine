package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.grid.FlightCancel;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/flight-cancel", layout = MainLayout.class)
public class FlightCancelView extends VerticalLayout {
    public FlightCancelView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Flight Cancel");
        CustomGrid<FlightCancel> delayGrid = new CustomGrid<>(FlightCancel.class, columnProviderFactory);
        delayGrid.updateItems(getFlightCancelData());
        add(title, delayGrid);

    }

    private List<FlightCancel> getFlightCancelData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/flight_cancel.json", new TypeReference<>() {
        });
    }


}
