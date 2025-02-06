package fr.epita.assistants.observer;

import java.util.HashSet;
import java.util.Set;

public class Swimmer implements Observable<Swimmer> {
    // 1) A set of observers watching this Swimmer:
    private final Set<Observer<Swimmer>> observers = new HashSet<>();

    // 2) The swimmer's name:
    private final String name;

    // 3) The swimmer's status, defaulting to OK:
    private SwimmerStatus status = SwimmerStatus.OK;

    /**
     * Constructor takes the name of the Swimmer.
     * When a Swimmer is created, display "<swimmer's name> goes into the sea."
     */
    public Swimmer(String name) {
        this.name = name;
        System.out.println(name + " goes into the sea.");
    }

    /**
     * @return The name of the Swimmer.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The current status of the Swimmer.
     */
    public SwimmerStatus getStatus() {
        return status;
    }

    /**
     * Sets the Swimmer’s status and notifies observers.
     * Also prints specific messages if the Swimmer is drowning or waving.
     *
     * @param newStatus The new status for this Swimmer.
     */
    public void setStatus(SwimmerStatus newStatus) {
        this.status = newStatus;

        // Print additional messages depending on the status:
        if (newStatus == SwimmerStatus.DROWNING) {
            System.out.println(name + ": I'm drowning, help!!");
        } else if (newStatus == SwimmerStatus.WAVING) {
            System.out.println(name + ": Waves towards the shore");
        }

        // Notify all observers that THIS Swimmer has changed status
        fire(this);
    }

    // -------------------------------------------------------------
    // Implementing the methods from Observable<Swimmer>
    // -------------------------------------------------------------
    @Override
    public Set<Observer<Swimmer>> getObservers() {
        return observers;
    }

    @Override
    public void register(Observer<Swimmer>... observers) {
        for (Observer<Swimmer> observer : observers) {
            this.observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer<Swimmer> observer) {
        this.observers.remove(observer);
    }

    /**
     * Notifies every registered observer by calling onEvent(...) 
     * with THIS Swimmer as the event object.
     */
    @Override
    public void fire(Swimmer event) {
        for (Observer<Swimmer> observer : observers) {
            observer.onEvent(event);
        }
    }
}
