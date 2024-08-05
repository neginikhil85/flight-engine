package com.learning.ui.view.events;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.grid.CustomGrid;
import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.DelayData;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.function.Predicate;

@Route(value = "/flight-delay", layout = MainLayout.class)
public class DelayView extends VerticalLayout {

    public DelayView(ColumnProviderFactory columnProviderFactory) {
        addClassName("delay-view");
        H1 title = new H1("Delay Events");

        CustomGrid<DelayData> delayGrid = new CustomGrid<>(DelayData.class, columnProviderFactory);
        GridListDataView<DelayData> delayDataView = delayGrid.updateItems(getDelayData());

        TextField searchField = new TextField();
        searchField.setPlaceholder("search...");
        searchField.setPrefixComponent(VaadinIcon.SEARCH.create());
        searchField.setValueChangeMode(ValueChangeMode.EAGER);
        searchField.addValueChangeListener(event -> delayDataView.refreshAll());

        delayDataView.addFilter(delayData -> {
            String searchTerm = searchField.getValue().trim();
            if (searchTerm.isEmpty())
                return true;

            return matchesTerm(String.valueOf(delayData.getFlightNumber()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getDateOfOrigin()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getStartStation()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getEndStation()), searchTerm) ||
                    matchesTerm(String.valueOf(delayData.getScheduleStartTime()), searchTerm) ||
                    matchesTerm(delayData.getDelayLimit(), searchTerm) ||
                    matchesTerm(delayData.getRemarks(), searchTerm) ||
                    matchesTerm(delayData.getTotal(), searchTerm) ||
                    anyMatches(delayData, e -> e.getReason().equals(searchTerm)) ||
                    anyMatches(delayData, e -> e.getDelayNumber().equals(searchTerm)) ||
                    anyMatches(delayData, e -> e.getRemark().equals(searchTerm));
        });

        add(title, searchField, delayGrid);
    }

    private static boolean anyMatches(DelayData delayData, Predicate<DelayData.DelayItem> predicate) {
        return delayData.getDelays().stream().anyMatch(predicate);
    }

    private List<DelayData> getDelayData() {
        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/delay_data.json", new TypeReference<>() {});
    }

    private boolean matchesTerm(String value, String searchTerm) {
        return value.toLowerCase().contains(searchTerm.toLowerCase());
    }

}
