package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.Equipment;
import com.learning.ui.model.FlightReturn;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/flight-return", layout = MainLayout.class)
public class FlightReturnView extends VerticalLayout {

    public FlightReturnView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Flight Return");
        CustomGrid<FlightReturn> delayGrid = new CustomGrid<>(FlightReturn.class, columnProviderFactory);
        delayGrid.updateItems(getFlightReturnData());
        add(title, delayGrid);

    }

    private List<FlightReturn> getFlightReturnData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/flight_return.json", new TypeReference<>() {
        });
    }
}
