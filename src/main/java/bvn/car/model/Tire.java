package bvn.car.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tires")
public class Tire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "wear_state")
    private double wearState;
    private String producer;
    private int radius;

    public Tire() {
    }

    public Tire(double wearState, String producer, int radius) {
        this.wearState = wearState;
        this.producer = producer;
        this.radius = radius;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
