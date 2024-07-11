package com.company.bpmdemo.listener;

import io.jmix.bpm.engine.events.ProcessCompletedEvent;
import io.jmix.bpm.engine.events.ProcessStartedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProcessEventsListener {
    private static final Logger log = LoggerFactory.getLogger(ProcessEventsListener.class);

    @EventListener
    public void onProcessStart(ProcessStartedEvent event) {
        String key = event.getProcessDefinition().getKey();
        log.info("Process started: {}", key);
    }

    @EventListener
    public void onProcessStart(ProcessCompletedEvent event) {
        String key = event.getProcessDefinition().getKey();
        log.info("Process completed: {}", key);
    }
}
