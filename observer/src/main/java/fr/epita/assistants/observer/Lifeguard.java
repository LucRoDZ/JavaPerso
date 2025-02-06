package fr.epita.assistants.observer;

/**
 * Lifeguard class that observes SwimmerStatus changes.
 */
public class Lifeguard implements Observable.Observer<SwimmerStatus> {

    private String name;

    public Lifeguard(String name) {
        this.name = name;
    }

    @Override
    public void onEvent(SwimmerStatus event) {
        // React based on the event (status of the swimmer)
        switch (event) {
            case DROWNING:
                System.out.println(name + ": The swimmer is drowning! I'm coming to help!");
                break;
            case TOO_FAR:
                System.out.println(name + ": The swimmer is too far away! Let me check the situation.");
                break;
            case WAVING:
                System.out.println(name + ": The swimmer is waving, they might need assistance.");
                break;
            case OK:
            default:
                System.out.println(name + ": The swimmer looks fine. No action needed right now.");
                break;
        }
    }
}
