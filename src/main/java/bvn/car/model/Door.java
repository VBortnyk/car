package bvn.car.model;

import java.util.Objects;

public class Door {
    private int id;
    private String carModel;
    private boolean closed;
    private boolean windowClosed;

    public Door(int id, String carModel) {
        this.id = id;
        this.carModel = carModel;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


