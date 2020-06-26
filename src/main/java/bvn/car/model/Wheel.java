package bvn.car.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wheels")
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int radius;
    @OneToOne
    private Tire tire;

    public Wheel() {
    }

    public Wheel(int radius) {
        this.id = id;
        this.radius = radius;
    }

    public Wheel(int radius, Tire tire) {
        this.id = id;
        this.radius = radius;
        this.tire = tire;
    }

    public boolean refreshTire(Tire tire) {
        if (tire != null) {
            if (this.radius == tire.getRadius()) {
                this.tire = tire;
                return true;
            }
            System.out.println("Tire radius doesn't match wheel radius");
            return false;
        }
        System.out.println("No tire to be refreshed");
        return false;
    }

    public double eraseTire(double degree) {
        Tire tire = this.getTire();
        if (tire.getWearState() > degree) {
            double newWearState = tire.getWearState() - degree;
            tire.setWearState(newWearState);
            return newWearState;
        }
        System.out.println("The tire is too weak already!");
        return tire.getWearState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRadius() {
        return radius;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wheel)) {
            return false;
        }
        Wheel wheel = (Wheel) o;
        return getRadius() == wheel.getRadius()
                && Objects.equals(getId(), wheel.getId())
                && Objects.equals(getTire(), wheel.getTire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRadius(), getTire());
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "id=" + id
                + ", radius=" + radius
                + ", tire=" + tire
                + '}';
    }
}
