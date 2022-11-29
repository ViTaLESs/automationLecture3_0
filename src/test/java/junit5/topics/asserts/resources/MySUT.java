package junit5.topics.asserts.resources;

import java.io.Closeable;
import java.util.UUID;
import java.util.stream.IntStream;

public class MySUT implements Closeable {

    String name;
    String id;

    public MySUT(String name) {
        this.name = name;
        System.out.println(name + " created");
    }

    public void initId() {
        id = UUID.randomUUID().toString();
        System.out.println("Id created: " + id);
    }

    public void releaseId() {
        if (id == null) {
            throw new IllegalArgumentException(name + " not initialized");
        }
        System.out.println("Id released: " + id);
        id = null;
    }

    public int sum(int... numbers) {
        return IntStream.of(numbers).sum();
    }

    public String concatenate(String... words) {
        return String.join(" ", words);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void close() {
        System.out.println(name + " closed");
    }

}
