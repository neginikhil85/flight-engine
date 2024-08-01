package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.DelayData;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "/flight-delay", layout = MainLayout.class)
public class DelayView extends VerticalLayout {

    public DelayView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Delay Events");
        CustomGrid<DelayData> delayGrid = new CustomGrid<>(DelayData.class, columnProviderFactory);
        delayGrid.updateItems(getDelayData());
        add(title, delayGrid);
    }

    private List<DelayData> getDelayData() {
        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/delay_data.json", new TypeReference<>() {});
    }
}
