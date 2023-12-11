package hw;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyClass myClass = new MyClass();
        myClass.serializableObject(new MyObject(1, "first"));
        myClass.deserializableObject();
    }
}
