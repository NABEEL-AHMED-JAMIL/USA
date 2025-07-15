package coding.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(42, 5, 12, 89, 23, 7, 56);
        Collections.sort(data);
        // get the sort data
        System.out.println(data);
        // get the 2nd last index
        System.out.println(data.get(data.size() - 2));
        // get the reverse order
        System.out.println(data);
    }
}
