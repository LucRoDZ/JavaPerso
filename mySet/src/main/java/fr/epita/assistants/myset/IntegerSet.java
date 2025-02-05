package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    private final ArrayList<Integer> base_;

    public IntegerSet() {
        this.base_ = new ArrayList<>();
    }

    public void insert(Integer i) {
        if (!base_.contains(i)) {
            base_.add(i);
            Collections.sort(base_);
        }
    }

    public void remove(Integer i) {
        base_.remove(i);
    }

    public boolean has(Integer i) {
        return base_.contains(i);
    }

    public boolean isEmpty() {
        return base_.isEmpty();
    }

    public Integer min() {
        return base_.get(0);
    }

    public Integer max() {
        return base_.get(base_.size() - 1);
    }

    public int size() {
        return base_.size();
    }

    public static IntegerSet intersection(IntegerSet a, IntegerSet b) {
        IntegerSet result = new IntegerSet();
        for (Integer i : a.base_) {
            if (b.has(i)) {
                result.insert(i);
            }
        }
        return result;
    }

    public static IntegerSet union(IntegerSet a, IntegerSet b) {
        IntegerSet result = new IntegerSet();
        for (Integer i : a.base_) {
            result.insert(i);
        }
        for (Integer i : b.base_) {
            result.insert(i);
        }
        return result;
    }
}
