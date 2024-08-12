package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.SearchableGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.enums.GridFilterBean;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.grid.DiversionData;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "/flight-diversion", layout = MainLayout.class)
public class DiversionView extends VerticalLayout {

    public DiversionView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Diversion Events");
        SearchableGrid<DiversionData> diversionGrid = new SearchableGrid<>(DiversionData.class, columnProviderFactory);
        diversionGrid.updateItems(getDiversionData());
        diversionGrid.setSearchFilters(GridFilterBean.DIVERSION_DATA.getBean());
        add(title, diversionGrid);
        

    }

    private List<DiversionData> getDiversionData() {

        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/diversion_data.json", new TypeReference<>() {});

    }
}
