package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.grid.LandingTime;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/landing-time", layout = MainLayout.class)
public class LandingTimeView extends VerticalLayout {
    public LandingTimeView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Landing Time");
        CustomGrid<LandingTime> delayGrid = new CustomGrid<>(LandingTime.class, columnProviderFactory);
        delayGrid.updateItems(getLandingTimeData());
        add(title, delayGrid);

    }

    private List<LandingTime> getLandingTimeData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/landing_time.json", new TypeReference<>() {
        });
    }
}
