package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.grid.ActualTime;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "/actual-time", layout = MainLayout.class)
public class ActualTimeView extends VerticalLayout {
    public ActualTimeView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Actual Time");
        CustomGrid<ActualTime> delayGrid = new CustomGrid<>(ActualTime.class, columnProviderFactory);
        delayGrid.updateItems(getActualTimeData());
        add(title, delayGrid);

    }

    private List<ActualTime> getActualTimeData() {
        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/actual_time.json", new TypeReference<>() {
        });
    }
}
