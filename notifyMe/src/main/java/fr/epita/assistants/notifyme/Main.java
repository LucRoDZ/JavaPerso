package fr.epita.assistants.notifyme;

import fr.epita.assistants.notifyme.notify.ShellNotifier;
import fr.epita.assistants.notifyme.user.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", List.of(new ShellNotifier(false), new ShellNotifier(true)));

        user.sendNotifications("ING1", "Hello World!");
    }
}

