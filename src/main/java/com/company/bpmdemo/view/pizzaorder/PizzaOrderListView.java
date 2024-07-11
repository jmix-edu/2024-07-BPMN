package com.company.bpmdemo.view.pizzaorder;

import com.company.bpmdemo.entity.PizzaOrder;
import com.company.bpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "pizzaOrders", layout = MainView.class)
@ViewController("PizzaOrder.list")
@ViewDescriptor("pizza-order-list-view.xml")
@LookupComponent("pizzaOrdersDataGrid")
@DialogMode(width = "64em")
public class PizzaOrderListView extends StandardListView<PizzaOrder> {
}