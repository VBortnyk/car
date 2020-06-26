package bvn.car.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "doors")
public class Door {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_model")
    private String carModel;
    @Transient
    private boolean closed;
    @Transient
    private boolean windowClosed;

    public Door() {
    }

    public Door(String carModel) {
        this.carModel = carModel;
        this.closed = true;
        this.windowClosed = true;
    }

    public void openDoor() {
        if (closed) {
            closed = false;
            System.out.println("The door is opened");
        }
    }

    public void closeDoor() {
        if (!closed) {
            closed = true;
            System.out.println("The door is closed");
        }
    }

    public void changeOpenCloseSate() {
        openDoor();
        closeDoor();
    }

    public void openWindow() {
        if (closed) {
            closed = false;
            System.out.println("The window is opened");
        }
    }

    public void closeWindow() {
        if (!closed) {
            closed = true;
            System.out.println("The window is closed");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isWindowClosed() {
        return windowClosed;
    }

    public void setWindowClosed(boolean windowClosed) {
        this.windowClosed = windowClosed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Door)) {
            return false;
        }
        Door door = (Door) o;
        return getId() == door.getId()
                && isClosed() == door.isClosed()
                && isWindowClosed() == door.isWindowClosed()
                && Objects.equals(getCarModel(), door.getCarModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCarModel());
    }

    @Override
    public String toString() {
        return "Door{"
                + "id=" + id
                + ", carModel='" + carModel + '\''
                + ", closed=" + closed
                + ", windowClosed=" + windowClosed
                + '}';
    }
}


