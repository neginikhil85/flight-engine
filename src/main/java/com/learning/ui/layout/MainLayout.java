package com.learning.ui.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        Image logoImage = new Image("images/indigo-logo.svg", "logo");

        H1 title = new H1("FE | Flight Engine");

        DrawerToggle drawerToggle = new DrawerToggle();
        HorizontalLayout header = new HorizontalLayout(drawerToggle, logoImage, title);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();

        header.setClassName("app-header");

        addToNavbar(header);
    }

    private void createDrawer() {
        H3 categories = new H3("Categories");
        Scroller scroller = new Scroller(new VerticalLayout(categories, getSideNav()));
        scroller.setClassName(LumoUtility.Padding.XSMALL);

        addToDrawer(scroller);
    }

    private SideNav getSideNav() {
        SideNav nav = new SideNav();
        nav.addItem(new SideNavItem("Flight Inquiry", "/flight-inquiry", VaadinIcon.FLIGHT_TAKEOFF.create()));

        SideNavItem events = new SideNavItem("Events");
        events.setPrefixComponent(VaadinIcon.EXCHANGE.create());
        events.addItem(new SideNavItem("Delay Events", "/flight-delay"));
        events.addItem(new SideNavItem("Diversion Events", "/flight-diversion"));
        events.addItem(new SideNavItem("Door Close", "/flight-door-close"));
        events.addItem(new SideNavItem("Estimated Time", "/estimated-time"));
        events.addItem(new SideNavItem("Actual Time", "/actual-time"));
        events.addItem(new SideNavItem("Equipment", "/equipment"));
        events.addItem(new SideNavItem("Flight Cancel", "/flight-cancel"));
        events.addItem(new SideNavItem("Flight Return", "/flight-return"));
        events.addItem(new SideNavItem("Flight Delete", "/flight-delete"));
        events.addItem(new SideNavItem("Terminal", "/terminal"));
        events.addItem(new SideNavItem("Operation Status", "/operation-status"));
        events.addItem(new SideNavItem("Gate Change", "/gate-change"));
        events.addItem(new SideNavItem("In Block Time", "/in-block-time"));
        events.addItem(new SideNavItem("Off Block Time", "/off-block-time"));
        events.addItem(new SideNavItem("Landing Time", "/landing-time"));
        events.addItem(new SideNavItem("Take Off Time", "/take-off-time"));

        nav.addItem(events);
        return nav;
    }
}
