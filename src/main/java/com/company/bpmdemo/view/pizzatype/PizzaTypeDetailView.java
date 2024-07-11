package com.company.bpmdemo.view.pizzatype;

import com.company.bpmdemo.entity.PizzaType;
import com.company.bpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "pizzaTypes/:id", layout = MainView.class)
@ViewController("PizzaType.detail")
@ViewDescriptor("pizza-type-detail-view.xml")
@EditedEntityContainer("pizzaTypeDc")
public class PizzaTypeDetailView extends StandardDetailView<PizzaType> {
}