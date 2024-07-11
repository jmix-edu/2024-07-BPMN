package com.company.bpmdemo.view.placeorderprocessform;


import com.company.bpmdemo.entity.PizzaType;
import com.company.bpmdemo.entity.User;
import com.company.bpmdemo.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.bpmflowui.processform.ProcessFormContext;
import io.jmix.bpmflowui.processform.annotation.OutputVariable;
import io.jmix.bpmflowui.processform.annotation.ProcessForm;
import io.jmix.bpmflowui.processform.annotation.ProcessVariable;
import io.jmix.flowui.component.textarea.JmixTextArea;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm(outputVariables = {
        @OutputVariable(name = "approver", type = User.class),
        @OutputVariable(name = "approverMessage", type = String.class),
        @OutputVariable(name = "deliveryNimber", type = String.class),
        @OutputVariable(name = "pizzaEater", type = User.class),
        @OutputVariable(name = "pizzaType", type = PizzaType.class),
        @OutputVariable(name = "specialReuirements", type = JmixTextArea.class)
})
@Route(value = "place-order-process-form", layout = MainView.class)
@ViewController("PlaceOrderProcessForm")
@ViewDescriptor("place-order-process-form.xml")
public class PlaceOrderProcessForm extends StandardView {

    @Autowired
    private ProcessFormContext processFormContext;
    @ProcessVariable(name = "approver")
    @ViewComponent
    private EntityPicker<User> approverField;
    @ProcessVariable(name = "approverMessage")
    @ViewComponent
    private TypedTextField<String> approverMessageField;
    @ProcessVariable(name = "deliveryNimber")
    @ViewComponent
    private TypedTextField<String> deliveryNimberField;
    @ProcessVariable(name = "pizzaEater")
    @ViewComponent
    private EntityPicker<User> pizzaEaterField;
    @ProcessVariable(name = "pizzaType")
    @ViewComponent
    private EntityPicker<PizzaType> pizzaTypeField;
    @ProcessVariable(name = "specialReuirements")
    @ViewComponent
    private JmixTextArea specialReuirementsField;

    @Subscribe(id = "completeBtn", subject = "clickListener")
    protected void onCompleteBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.taskCompletion()
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }
}