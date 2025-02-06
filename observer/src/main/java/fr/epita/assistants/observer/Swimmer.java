package fr.epita.assistants.observer;

import java.util.HashSet;
import java.util.Set;

public class Swimmer implements Observable<SwimmerStatus> {

    private final Set<Observer<SwimmerStatus>> observers = new HashSet<>();

    // Current status of the Swimmer
    private SwimmerStatus status = SwimmerStatus.OK;

    // A simple name field to identify the Swimmer
    private final String name;

    public Swimmer(String name) {
        this.name = name;
    }

    /**
     * Change the swimmer's status and notify observers about it.
     * @param newStatus The new status of the Swimmer.
     */
    public void setStatus(SwimmerStatus newStatus) {
        this.status = newStatus;
        // Notify all observers of the change
        fire(newStatus);
    }

    public SwimmerStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    // ----------------------------------------------------
    // Methods from Observable
    // ----------------------------------------------------
    @Override
    public Set<Observer<SwimmerStatus>> getObservers() {
        return observers;
    }

    @Override
    public void register(Observer<SwimmerStatus>... observers) {
        for (Observer<SwimmerStatus> obs : observers) {
            this.observers.add(obs);
        }
    }

    @Override
    public void unregister(Observer<SwimmerStatus> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void fire(SwimmerStatus event) {
        // Notify every registered observer with the event
        for (Observer<SwimmerStatus> obs : observers) {
            obs.onEvent(event);
        }
    }
}
