package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.TakeOffTime;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/take-off-time", layout = MainLayout.class)
public class TakeOffTimeView extends VerticalLayout {
    public TakeOffTimeView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Take Off Time");
        CustomGrid<TakeOffTime> delayGrid = new CustomGrid<>(TakeOffTime.class, columnProviderFactory);
        delayGrid.updateItems(getTakeOffTimeData());
        add(title, delayGrid);

    }

    private List<TakeOffTime> getTakeOffTimeData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/take_off_time.json", new TypeReference<>() {
        });
    }
}
