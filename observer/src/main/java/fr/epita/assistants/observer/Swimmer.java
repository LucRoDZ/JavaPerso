package fr.epita.assistants.observer;

public class Lifeguard implements Observable.Observer<SwimmerStatus> {

    private final String name;

    public Lifeguard(String name) {
        this.name = name;
    }

    @Override
    public void onEvent(SwimmerStatus event) {
        switch (event) {
            case DROWNING:
                System.out.println(name + " => The swimmer is drowning! I'm rescuing them!");
                break;
            case TOO_FAR:
                System.out.println(name + " => The swimmer is too far. I'm signaling them to come closer.");
                break;
            case WAVING:
                System.out.println(name + " => The swimmer is waving. Checking if they need help!");
                break;
            case OK:
            default:
                System.out.println(name + " => The swimmer is OK. No action needed right now.");
                break;
        }
    }
}
