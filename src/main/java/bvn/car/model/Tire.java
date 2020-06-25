package bvn.car.model;

import java.util.Objects;

public class Tire {
    private double wearState;
    private String producer;
    private int radius;

    public Tire(double wearState, String producer, int radius) {
        this.wearState = wearState;
        this.producer = producer;
        this.radius = radius;
    }

    public double getWearState() {
        return wearState;
    }

    public void setWearState(double wearState) {
        this.wearState = wearState;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tire)) {
            return false;
        }
        Tire tire = (Tire) o;
        return Double.compare(tire.getWearState(), getWearState()) == 0
                && getRadius() == tire.getRadius()
                && Objects.equals(getProducer(), tire.getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWearState(), getProducer(), getRadius());
    }

    @Override
    public String toString() {
        return "Tire{"
                + "wearState=" + wearState
                + ", producer='"
                + producer + '\''
                + ", radius=" + radius
                + '}';
    }
}
