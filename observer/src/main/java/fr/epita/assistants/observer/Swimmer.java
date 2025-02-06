package fr.epita.assistants.observer;

import java.util.HashSet;
import java.util.Set;

public class Swimmer extends Person implements Observable<SwimmerStatus> {

    // Current status of the swimmer
    private SwimmerStatus status = SwimmerStatus.OK;

    // A set to hold all observers (e.g., lifeguards)
    private final Set<Observer<SwimmerStatus>> observers = new HashSet<>();

    public Swimmer(String name, int age) {
        super(name, age);
    }

    // Method to update the Swimmer's status
    public void setStatus(SwimmerStatus newStatus) {
        this.status = newStatus;
        // Whenever status changes, notify all observers
        fire(newStatus);
    }

    public SwimmerStatus getStatus() {
        return status;
    }

    // ===================
    // Observable methods:
    // ===================

    @Override
    public Set<Observer<SwimmerStatus>> getObservers() {
        return observers;
    }

    @Override
    @SafeVarargs
    public final void register(Observer<SwimmerStatus>... observersToRegister) {
        for (Observer<SwimmerStatus> observer : observersToRegister) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer<SwimmerStatus> observer) {
        observers.remove(observer);
    }

    @Override
    public void fire(SwimmerStatus event) {
        // Notify all observers about the event
        for (Observer<SwimmerStatus> observer : observers) {
            observer.onEvent(event);
        }
    }
}
