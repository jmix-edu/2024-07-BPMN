package com.company.bpmdemo.view.pizzatype;

import com.company.bpmdemo.entity.PizzaType;
import com.company.bpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "pizzaTypes", layout = MainView.class)
@ViewController("PizzaType.list")
@ViewDescriptor("pizza-type-list-view.xml")
@LookupComponent("pizzaTypesDataGrid")
@DialogMode(width = "64em")
public class PizzaTypeListView extends StandardListView<PizzaType> {
}