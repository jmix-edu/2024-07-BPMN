package com.company.bpmdemo.app;

import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalTime.now;

@Component(value = "greetingMessageBean")
public class GreetingMessageBean {

    public LocalTime printMessage(String greeting,
                                  String message,
                                  DelegateExecution execution)
    {
        System.out.println("Service task: " + execution.getCurrentActivityId());
        System.out.println(greeting + "! "  + message);
        return now();
    }

    public void printTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String formattedTime = time.format(formatter);
        System.out.println("Time is: " + formattedTime);
    }

}