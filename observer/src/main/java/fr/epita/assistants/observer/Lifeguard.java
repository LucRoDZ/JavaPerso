package fr.epita.assistants.observer;

public class Lifeguard implements Observable.Observer<Swimmer> {
    private final String name;

    /**
     * Constructor takes the name of the Lifeguard.
     * When a Lifeguard is created, display:
     * "<lifeguard's name> begins to keep an eye on the swimmers."
     */
    public Lifeguard(String name) {
        this.name = name;
        System.out.println(name + " begins to keep an eye on the swimmers.");
    }

    /**
     * Reacts to events from a Swimmer.
     *
     * @param swimmer The Swimmer that triggered the event.
     */
    @Override
    public void onEvent(Swimmer swimmer) {
        SwimmerStatus currentStatus = swimmer.getStatus();

        // If a swimmer is drowning:
        if (currentStatus == SwimmerStatus.DROWNING) {
            System.out.println(name + ": I will save you " + swimmer.getName() + "!");
        }
        // If a swimmer is too far:
        else if (currentStatus == SwimmerStatus.TOO_FAR) {
            System.out.println(name + ": " + swimmer.getName() + "! You are too far, come back!");
        }
        // Other statuses are not specifically mentioned for Lifeguard's reaction
        // (OK, WAVING, etc.), so the lifeguard does nothing for them in this example.
    }
}
