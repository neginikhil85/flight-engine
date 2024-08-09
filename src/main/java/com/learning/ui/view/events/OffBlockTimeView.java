package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.OffBlockTime;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/off-block-time", layout = MainLayout.class)
public class OffBlockTimeView extends VerticalLayout {
    public OffBlockTimeView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Off Block Time");
        CustomGrid<OffBlockTime> delayGrid = new CustomGrid<>(OffBlockTime.class, columnProviderFactory);
        delayGrid.updateItems(getOffBlockTimeData());
        add(title, delayGrid);

    }

    private List<OffBlockTime> getOffBlockTimeData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/off_block_time.json", new TypeReference<>() {
        });
    }
}
