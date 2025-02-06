package fr.epita.assistants.observer;

public class Person implements Observable.Observer<Swimmer> {
    private final String name;

    /**
     * Constructor takes the name of the Person.
     * When a Person is created, display:
     * "<person's name> is taking a walk on the beach."
     */
    public Person(String name) {
        this.name = name;
        System.out.println(name + " is taking a walk on the beach.");
    }

    /**
     * React to events from a Swimmer.
     *
     * @param swimmer The Swimmer that triggered the event.
     */
    @Override
    public void onEvent(Swimmer swimmer) {
        // If a swimmer is waving, the person waves back:
        if (swimmer.getStatus() == SwimmerStatus.WAVING) {
            System.out.println(name + ": Waves back at " + swimmer.getName() + ".");
        }
        // Other statuses (OK, DROWNING, TOO_FAR) do not require a Person’s reaction.
    }
}
