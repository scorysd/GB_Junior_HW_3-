package hw;

import java.io.Serializable;

public class MyObject implements Serializable {
    private int number;
    private String name;

    public MyObject(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
