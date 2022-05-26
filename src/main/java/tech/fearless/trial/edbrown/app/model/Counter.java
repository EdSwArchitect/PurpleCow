package tech.fearless.trial.edbrown.app.model;

import java.util.StringJoiner;

public class Counter {
    private long value;

    public Counter() {

    }


    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Counter counter = (Counter) o;

        return value == counter.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Counter.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
