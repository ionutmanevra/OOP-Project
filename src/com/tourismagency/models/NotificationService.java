package com.tourismagency.models;

import com.tourismagency.interfaces.Notifiable;

public class NotificationService implements Notifiable {
    private String serviceName;

    public NotificationService(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[" + serviceName + "] Sending notification: " + message);
    }
}
