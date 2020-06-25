package bvn.car.model;

import java.util.Objects;

public class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Passenger)) {
            return false;
        }
        Passenger passenger = (Passenger) o;
        return Objects.equals(getName(), passenger.getName())
                && Objects.equals(getAge(), passenger.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Passenger{"
                + "name='" + name + '\''
                + ", age='" + age + '\''
                + '}';
    }
}

