package com.learning.ui.view.inquiry;

import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.learning.ui.model.grid.FlightLegState;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.List;

@Route(value = "/flight-inquiry", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class FlightInquiryView extends VerticalLayout {

    private FlightDataView dataView;
    private FlightFormView formView;
    private Button toggleButton;

    public FlightInquiryView(ColumnProviderFactory columnProviderFactory) {
        setClassName("flight-inquiry-layout");
        setSizeFull();

        // Create header layout
        Div header = createHeaderLayout();

        // Create contents layout
        Div contents = createContentLayout(columnProviderFactory);

        makeViewResponsive();

        add(header, contents);
    }

    private void makeViewResponsive() {
        try {
            if (formView.isVisible() && Double.parseDouble(this.getWidth()) < 1300) {
                formView.setVisible(false);
                toggleButton.setText("Show Form");
            }
        } catch (Exception ignored) {}
    }

    private Div createContentLayout(ColumnProviderFactory columnProviderFactory) {
        dataView = new FlightDataView(columnProviderFactory);
        formView = new FlightFormView();
        Div contents = new Div(dataView, formView);
        contents.addClassName("contents");
        return contents;
    }

    private Div createHeaderLayout() {
        H1 viewTitle = new H1("Flight Inquiry");
        toggleButton = new Button("Hide Form", event -> toggleFormVisibility());
        Div header = new Div(viewTitle, toggleButton);
        header.addClassName("header");
        return header;
    }

    private void toggleFormVisibility() {
        boolean isFormVisible = formView.isVisible();
        formView.setVisible(!isFormVisible);
        toggleButton.setText(isFormVisible ? "Show Form" : "Hide Form");
    }

    public void setFlightResponseInGrid(List<FlightLegState> flightData) {
        dataView.updateGridData(flightData);
    }
}


