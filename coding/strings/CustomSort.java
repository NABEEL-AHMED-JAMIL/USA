package coding.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSort implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(2, "Alice"));
        list.add(new Student(1, "Bob"));
        Collections.sort(list, new CustomSort());
        System.out.println(list);
    }
}
