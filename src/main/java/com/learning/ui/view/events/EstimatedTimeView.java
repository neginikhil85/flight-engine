package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.grid.EstimatedTime;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "/estimated-time", layout = MainLayout.class)
public class EstimatedTimeView extends VerticalLayout {

    public EstimatedTimeView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Estimated Time");
        CustomGrid<EstimatedTime> delayGrid = new CustomGrid<>(EstimatedTime.class, columnProviderFactory);
        delayGrid.updateItems(getEstimatedTimeData());
        add(title, delayGrid);

    }

    private List<EstimatedTime> getEstimatedTimeData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/estimated_time.json", new TypeReference<>() {
        });

    }
}
