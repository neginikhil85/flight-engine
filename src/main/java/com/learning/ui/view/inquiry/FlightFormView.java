package com.learning.ui.view.inquiry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.learning.ui.component.form.FlightForm;
import com.learning.ui.model.grid.FlightLegState;
import com.learning.util.JsonFileReader;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;

public class FlightFormView extends VerticalLayout {

    private FlightForm flightForm;
    private Button queryBtn;

    public FlightFormView() {
        addClassName("form-view");

        Div title = new Div("New Flight Query");
        title.setClassName("form-view-title");

        flightForm = new FlightForm();
        queryBtn = new Button("Query");

        queryBtn.addClickListener(click -> onQuery());

        add(title, flightForm, queryBtn);
    }

    public void onQuery() {
        boolean mandatoryFieldNull = isMandatoryFieldNull(flightForm.getStartDateTime(), flightForm.getEndDateTime());
        if (mandatoryFieldNull) {
            showError("Mandatory Field missing");
        } else {
            UI.getCurrent().navigate(FlightInquiryView.class)
                    .ifPresent(flightInquiryView -> {
                        flightInquiryView.setFlightResponseInGrid(getFlightData());
                    });
        }

        flightForm.getFields().values().forEach(HasValue::clear);

    }

    private static void showError(String text) {
        Notification errorNotify = new Notification(text);
        errorNotify.addThemeVariants(NotificationVariant.LUMO_ERROR);
        errorNotify.setPosition(Notification.Position.TOP_END);
        errorNotify.setDuration(1200);
        errorNotify.open();
    }

    private boolean isMandatoryFieldNull(AbstractField<?,?>... abstractFields) {
        return Arrays.stream(abstractFields).map(AbstractField::getValue).anyMatch(ObjectUtils::isEmpty);
    }

    private List<FlightLegState> getFlightData() {
        JsonFileReader fileReader = new JsonFileReader();
        return fileReader.readFile("src/main/resources/flight_data.json", new TypeReference<>() {});
    }
}
