package com.company.bpmdemo.listener;

import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ApproverAssignedListener implements TaskListener {
    private static final Logger log = LoggerFactory.getLogger(ApproverAssignedListener.class);

    @Override
    public void notify(DelegateTask delegateTask) {
        String assigneeUsername = delegateTask.getAssignee();
        delegateTask.setVariable("approver", assigneeUsername);


        log.info("Task listener: {}", assigneeUsername);
    }
}
