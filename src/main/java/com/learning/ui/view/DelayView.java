package com.learning.ui.view;

import com.learning.ui.component.card.CustomCard;
import com.learning.ui.component.chart.DonutChart;
import com.learning.ui.layout.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/flight-delay", layout = MainLayout.class)
public class DelayView extends VerticalLayout {

    public DelayView() {
        CustomCard customCard = new CustomCard("Delay Events", true);
        customCard.addContent(new DonutChart().build());

        add(customCard);
    }
}
