package hw;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class MyClass {
       public MyClass() {
    }

    public void serializableObject(Object object) throws IOException {
        String path = object.getClass().getName() + "_" + UUID.randomUUID().toString();
        OutputStream outputStream = Files.newOutputStream(Path.of(path));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }
    public void deserializableObject() throws IOException, ClassNotFoundException {
        File file = new File(".");
        File startFileName = new File("./src/main/java");
        String[] listOfNames = startFileName.list();
        String[] listOfFiles = file.list();
        String path = Arrays.stream(listOfFiles)
                .filter(it -> it.startsWith(listOfNames[0].toString()))
                .collect(Collectors.joining());
        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Path.of(path)));
        Object object = objectInputStream.readObject();
        System.out.println(object);
        File delFile = new File(Path.of(path).toUri());
        delFile.delete();
        objectInputStream.close();

    }
}
