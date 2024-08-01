package com.learning.ui.view.inquiry;

import com.learning.ui.component.grid.provider.ColumnProviderFactory;
import com.learning.ui.layout.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

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
        H1 formTitle = new H1("Flight Inquiry");
        toggleButton = new Button("Hide Form", event -> toggleFormVisibility());
        Div header = new Div(formTitle, toggleButton);
        header.addClassName("header");

        // Create contents layout
        dataView = new FlightDataView(columnProviderFactory);
        formView = new FlightFormView();
        Div contents = new Div(dataView, formView);
        contents.addClassName("contents");

        add(header, contents);
    }

    private void toggleFormVisibility() {
        boolean isFormVisible = formView.isVisible();
        formView.setVisible(!isFormVisible);
        toggleButton.setText(isFormVisible ? "Show Form" : "Hide Form");
    }
}


