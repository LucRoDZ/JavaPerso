package fr.epita.assistants.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Swimmer class that extends Person and implements Observable<SwimmerStatus>.
 */
public class Swimmer extends Person implements Observable<SwimmerStatus> {

    private SwimmerStatus status;
    // We store our observers in a Set to avoid duplicates
    private final Set<Observer<SwimmerStatus>> observers = new HashSet<>();

    public Swimmer(String name) {
        super(name);
        // By default, let's assume a new Swimmer is OK at the start
        this.status = SwimmerStatus.OK;
    }

    public SwimmerStatus getStatus() {
        return status;
    }

    /**
     * Changes the swimmer's status and notifies all observers.
     */
    public void setStatus(SwimmerStatus newStatus) {
        this.status = newStatus;
        // Fire the event so all observers (e.g., Lifeguards) get notified
        fire(newStatus);
    }

    // =================================
    // Implementation of Observable<SwimmerStatus> methods
    // =================================

    @Override
    public Set<Observer<SwimmerStatus>> getObservers() {
        return observers;
    }

    @Override
    public void register(final Observer<SwimmerStatus>... observers) {
        for (Observer<SwimmerStatus> observer : observers) {
            this.observers.add(observer);
        }
    }

    @Override
    public void unregister(final Observer<SwimmerStatus> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void fire(final SwimmerStatus event) {
        // Notify each observer about the new event/status
        for (Observer<SwimmerStatus> observer : observers) {
            observer.onEvent(event);
        }
    }
}
