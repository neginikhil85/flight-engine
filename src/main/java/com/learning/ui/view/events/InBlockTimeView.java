package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.InBlockTime;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
@Route(value = "/in-block-time", layout = MainLayout.class)
public class InBlockTimeView extends VerticalLayout {
    public InBlockTimeView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("In Block Time");
        CustomGrid<InBlockTime> delayGrid = new CustomGrid<>(InBlockTime.class, columnProviderFactory);
        delayGrid.updateItems(getInBlockTimeData());
        add(title, delayGrid);

    }

    private List<InBlockTime> getInBlockTimeData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/in_block_time.json", new TypeReference<>() {
        });
    }
}
