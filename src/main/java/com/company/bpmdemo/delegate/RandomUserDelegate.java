package com.company.bpmdemo.delegate;

import com.company.bpmdemo.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("randomUserDelegate")
public class RandomUserDelegate implements JavaDelegate {
    private final SystemAuthenticator authenticator;
    private final DataManager dataManager;

    public RandomUserDelegate(SystemAuthenticator systemAuthenticator, DataManager dataManager) {
        this.authenticator = systemAuthenticator;
        this.dataManager = dataManager;
    }

    @Override
    public void execute(DelegateExecution execution) {
        List<User> userList;
        Long randomIndex = (Long) execution.getVariable("randomIndex");
        authenticator.begin();
        try {
            userList = dataManager.load(User.class).all().list();
        } finally {
            authenticator.end();
        }
        String username = userList.get(Math.toIntExact(randomIndex))
                .getUsername().toUpperCase();
        String message = (String) execution.getVariable("message");
        execution.setVariable("message", username + ", " + message);

        System.out.println("Service task: " + execution.getCurrentActivityId() +
                ", username: " + username);     }
}