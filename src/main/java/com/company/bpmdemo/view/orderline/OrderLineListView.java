package com.company.bpmdemo.view.orderline;

import com.company.bpmdemo.entity.OrderLine;
import com.company.bpmdemo.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "orderLines", layout = MainView.class)
@ViewController("OrderLine.list")
@ViewDescriptor("order-line-list-view.xml")
@LookupComponent("orderLinesDataGrid")
@DialogMode(width = "64em")
public class OrderLineListView extends StandardListView<OrderLine> {
}