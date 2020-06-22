package bvn.car.model;

import java.util.Objects;

public class Door {
    private int id;
    private DoorMarker doorMarker;
    private String carModel;
    private boolean closed;
    private boolean windowClosed;

    public Door(int id, DoorMarker doorMarker, String carModel) {
        this.id = id;
        this.doorMarker = doorMarker;
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

    public DoorMarker getDoorMarker() {
        return doorMarker;
    }

    public void setDoorMarker(DoorMarker doorMarker) {
        this.doorMarker = doorMarker;
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
                && getDoorMarker() == door.getDoorMarker()
                && Objects.equals(getCarModel(), door.getCarModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDoorMarker(), getCarModel());
    }

    @Override
    public String toString() {
        return "Door{"
                + "id=" + id
                + ", doorMarker=" + doorMarker
                + ", carModel='" + carModel + '\''
                + ", closed=" + closed
                + ", windowClosed=" + windowClosed
                + '}';
    }

    public enum DoorMarker {
        FRONT_LEFT, FRONT_RIGHT, BACK_LEFT, BACK_RIGHT;
    }
}


