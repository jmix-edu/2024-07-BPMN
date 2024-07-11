package com.company.bpmdemo.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class MyDelegate implements JavaDelegate {

    private int counter;

    public MyDelegate() {
        System.out.println("Instance created: " + this
                + " with hash: " + this.hashCode());
    }

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("MyDelegate executed: "
                + " hash: " + this.hashCode()
                + ", activity id: " + execution.getCurrentActivityId()
                + ", counter: " + counter++);
    }
}