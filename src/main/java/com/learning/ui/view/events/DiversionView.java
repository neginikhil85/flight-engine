package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.DelayData;
import com.learning.ui.model.DiversionData;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Collection;
import java.util.List;

@Route(value = "/flight-diversion", layout = MainLayout.class)
public class DiversionView extends VerticalLayout {

    public DiversionView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Diversion Events");
        CustomGrid<DiversionData> delayGrid = new CustomGrid<>(DiversionData.class, columnProviderFactory);
        delayGrid.updateItems(getDiversionData());
        add(title, delayGrid);

    }

    private List<DiversionData> getDiversionData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/diversion_data.json", new TypeReference<>() {});

    }
}
