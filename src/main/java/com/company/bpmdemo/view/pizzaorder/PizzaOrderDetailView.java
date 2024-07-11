package com.company.bpmdemo.view.pizzaorder;

import com.company.bpmdemo.entity.PizzaOrder;
import com.company.bpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "pizzaOrders/:id", layout = MainView.class)
@ViewController("PizzaOrder.detail")
@ViewDescriptor("pizza-order-detail-view.xml")
@EditedEntityContainer("pizzaOrderDc")
public class PizzaOrderDetailView extends StandardDetailView<PizzaOrder> {
}