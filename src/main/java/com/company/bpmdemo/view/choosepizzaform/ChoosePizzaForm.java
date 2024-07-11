package com.company.bpmdemo.view.choosepizzaform;


import com.company.bpmdemo.entity.PizzaType;
import com.company.bpmdemo.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.bpmflowui.processform.ProcessFormContext;
import io.jmix.bpmflowui.processform.annotation.Outcome;
import io.jmix.bpmflowui.processform.annotation.OutputVariable;
import io.jmix.bpmflowui.processform.annotation.ProcessForm;
import io.jmix.bpmflowui.processform.annotation.ProcessVariable;
import io.jmix.flowui.component.textarea.JmixTextArea;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm(outcomes = {
        @Outcome(id = "chosen"),
        @Outcome(id = "notHungry")
}, outputVariables = {
        @OutputVariable(name = "message", type = String.class),
        @OutputVariable(name = "pizzaType", type = PizzaType.class),
        @OutputVariable(name = "specialRequrements", type = JmixTextArea.class)
})
@Route(value = "choose-pizza-form", layout = MainView.class)
@ViewController("ChoosePizzaForm")
@ViewDescriptor("choose-pizza-form.xml")
public class ChoosePizzaForm extends StandardView {

    @Autowired
    private ProcessFormContext processFormContext;
    @ProcessVariable(name = "message")
    @ViewComponent
    private TypedTextField<String> messageField;
    @ProcessVariable(name = "pizzaType")
    @ViewComponent
    private EntityPicker<PizzaType> pizzaTypeField;
    @ProcessVariable(name = "specialRequrements")
    @ViewComponent
    private JmixTextArea specialRequrementsField;

    @Subscribe(id = "chosenBtn", subject = "clickListener")
    protected void onChosenBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.taskCompletion()
                .withOutcome("chosen")
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }

    @Subscribe(id = "notHungryBtn", subject = "clickListener")
    protected void onNotHungryBtnClick(ClickEvent<JmixButton> event) {
        processFormContext.taskCompletion()
                .withOutcome("notHungry")
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }
}