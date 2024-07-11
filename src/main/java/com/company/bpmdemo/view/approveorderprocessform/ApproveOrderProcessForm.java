package com.company.bpmdemo.view.approveorderprocessform;


import com.company.bpmdemo.entity.User;
import com.company.bpmdemo.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.bpmflowui.processform.ProcessFormContext;
import io.jmix.bpmflowui.processform.annotation.Outcome;
import io.jmix.bpmflowui.processform.annotation.OutputVariable;
import io.jmix.bpmflowui.processform.annotation.ProcessForm;
import io.jmix.bpmflowui.processform.annotation.ProcessVariable;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm(outcomes = {
        @Outcome(id = "submit"),
        @Outcome(id = "reject")
}, outputVariables = {
        @OutputVariable(name = "approverMessage", type = String.class),
        @OutputVariable(name = "pizzaEater", type = User.class)
})
@Route(value = "approve-order-process-form", layout = MainView.class)
@ViewController("ApproveOrderProcessForm")
@ViewDescriptor("approve-order-process-form.xml")
public class ApproveOrderProcessForm extends StandardView {

    @Autowired
    private ProcessFormContext processFormContext;
    @ProcessVariable(name = "approverMessage")
    @ViewComponent
    private TypedTextField<String> approverMessageField;
    @ProcessVariable(name = "pizzaEater")
    @ViewComponent
    private EntityPicker<User> pizzaEaterField;

    @Subscribe(id = "submitBtn", subject = "clickListener")
    protected void onSubmitBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.taskCompletion()
                .withOutcome("submit")
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }

    @Subscribe(id = "rejectBtn", subject = "clickListener")
    protected void onRejectBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.taskCompletion()
                .withOutcome("reject")
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }
}