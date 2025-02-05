package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.INotificationSender;

import java.util.ArrayList;
import java.util.List;

public class User implements IMultiNotificationSender {
    private final String username;
    private final List<INotificationSender> notifiers;

    public User(final String username, final List<INotificationSender> parNotificationList) {
        this.username = username;
        this.notifiers = new ArrayList<>(parNotificationList);
    }

    public User(final String username) {
        this(username, new ArrayList<>());
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void sendNotifications(String parRecipient, String parMessage) {
        for (INotificationSender notifier : notifiers) {
            notifier.notify(username, parRecipient, parMessage);
        }
    }

    @Override
    public void addNotifier(INotificationSender parNotifier) {
        if (parNotifier != null) {
            notifiers.add(parNotifier);
        }
    }

    @Override
    public List<INotificationSender> getNotifiers() {
        return notifiers;
    }
}
