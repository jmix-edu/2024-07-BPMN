package com.company.bpmdemo.listener;

import com.company.bpmdemo.entity.User;
import io.jmix.bpm.engine.events.UserTaskAssignedEvent;
import io.jmix.core.DataManager;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.notifications.NotificationManager;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskAssignedNotificationSender {

    @Autowired
    private UnconstrainedDataManager unconstrainedDataManager;
    @Autowired
    private NotificationManager notificationManager;

    @EventListener
    public void onTaskAssigned(UserTaskAssignedEvent event) {
        User user = unconstrainedDataManager.load(User.class)
                .query("select u from User u where u.username = :username")
                .parameter("username", event.getUsername())
                .one();

        Task task = event.getTask();

        notificationManager.createNotification()
                .withSubject("New task")
                .withRecipients(user)
                .toChannelsByNames("in-app")
                .withPlainTextContentType()
                .withTypeName("task")
                .withBody("A new task  [" + task.getName() + "] is assigned to You")
                .send();

    }
}
