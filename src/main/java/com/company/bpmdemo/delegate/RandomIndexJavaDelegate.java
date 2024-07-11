package com.company.bpmdemo.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import java.util.Random;

public class RandomIndexJavaDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        long numberOfUsers = (long) execution.getVariable("numberOfUsers");
        long randomIndex = new Random().nextLong(numberOfUsers);
        execution.setVariable("randomIndex", randomIndex);

        System.out.println("Service task: " + execution.getCurrentActivityId()
                + ", randomIndex: " + randomIndex);
    }
}