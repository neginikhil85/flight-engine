package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.GateChange;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/gate-change", layout = MainLayout.class)
public class GateChangeView extends VerticalLayout {
    public GateChangeView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Gate Change");
        CustomGrid<GateChange> delayGrid = new CustomGrid<>(GateChange.class, columnProviderFactory);
        delayGrid.updateItems(getGateChangeData());
        add(title, delayGrid);

    }

    private List<GateChange> getGateChangeData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/gate_change.json", new TypeReference<>() {
        });
    }
}
