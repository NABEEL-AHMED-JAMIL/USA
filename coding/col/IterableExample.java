package coding.col;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterableExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charling");
        for (String name : names) {
            System.out.println(name);
        }
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.hasNext());
        }
    }
}
