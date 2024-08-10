package com.learning.ui.view.inquiry;

import com.learning.ui.component.grid.SearchableGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.enums.GridFilterBean;
import com.learning.ui.model.grid.FlightLegState;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class FlightDataView extends VerticalLayout {

    private SearchableGrid<FlightLegState> flightInfoGrid;

    public FlightDataView(ColumnProviderFactory columnProviderFactory) {
        addClassName("data-view");

        H1 title = new H1("Flight Data");

        flightInfoGrid = new SearchableGrid<>(FlightLegState.class, columnProviderFactory);
        flightInfoGrid.setSearchFilters(GridFilterBean.FLIGHT_DATA.getBean());

        add(title, flightInfoGrid);
        setSizeFull();
        setFlexGrow(1, flightInfoGrid);
    }

    public void updateGridData(List<FlightLegState> flightLegStates) {
        flightInfoGrid.updateItems(flightLegStates);
    }
}
