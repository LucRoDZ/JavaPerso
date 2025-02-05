package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collections;

public class GenericSet<T extends Comparable<T>> {
    private final ArrayList<T> base_;

    public GenericSet() {
        this.base_ = new ArrayList<>();
    }

    public void insert(T element) {
        if (!base_.contains(element)) {
            base_.add(element);
            Collections.sort(base_);
        }
    }

    public void remove(T element) {
        base_.remove(element);
    }

    public boolean has(T element) {
        return base_.contains(element);
    }

    public boolean isEmpty() {
        return base_.isEmpty();
    }

    public T min() {
        return base_.get(0);
    }

    public T max() {
        return base_.get(base_.size() - 1);
    }

    public int size() {
        return base_.size();
    }

    public static <T extends Comparable<T>> GenericSet<T> intersection(GenericSet<T> a, GenericSet<T> b) {
        GenericSet<T> result = new GenericSet<>();
        for (T element : a.base_) {
            if (b.has(element)) {
                result.insert(element);
            }
        }
        return result;
    }

    public static <T extends Comparable<T>> GenericSet<T> union(GenericSet<T> a, GenericSet<T> b) {
        GenericSet<T> result = new GenericSet<>();
        for (T element : a.base_) {
            result.insert(element);
        }
        for (T element : b.base_) {
            result.insert(element);
        }
        return result;
    }
}
