package com.learning.ui.view.inquiry;

import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.model.FlightLegState;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class FlightDataView extends VerticalLayout {

    private CustomGrid<FlightLegState> flightInfoGrid;

    public FlightDataView(ColumnProviderFactory columnProviderFactory) {
        addClassName("data-view");

        H1 title = new H1("Flight Data");

        flightInfoGrid = new CustomGrid<>(FlightLegState.class, columnProviderFactory);

        add(title, flightInfoGrid);
        setSizeFull();
        setFlexGrow(1, flightInfoGrid);
    }

    public void updateGridData(List<FlightLegState> flightLegStates) {
        flightInfoGrid.setItems(flightLegStates);
    }
}
