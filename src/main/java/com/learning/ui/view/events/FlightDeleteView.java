package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.FlightDelete;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/flight-delete", layout = MainLayout.class)
public class FlightDeleteView extends VerticalLayout {

    public FlightDeleteView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Flight Delete");
        CustomGrid<FlightDelete> delayGrid = new CustomGrid<>(FlightDelete.class, columnProviderFactory);
        delayGrid.updateItems(getFlightDeleteData());
        add(title, delayGrid);

    }

    private List<FlightDelete> getFlightDeleteData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/flight_delete.json", new TypeReference<>() {
        });
    }
}
