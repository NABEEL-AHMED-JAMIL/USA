package coding.gen;

import java.util.*;
import java.util.stream.Collectors;

public class TechMahindra {

    public static void main(String[] args) {
        int[] aray = {1 ,2 ,3 ,4, 5};
        int[] array2 = new int[aray.length-1];
        int j = 0;
        for (int i=0; i<aray.length; i++) {
            if (aray[j] != 3) {
                array2[i] = aray[j];
                j++;
            }
        }
        System.out.println(array2);
        List<String> list = Arrays.asList("Nabeel", "Nabeel", "Edition", "Apple", "File");
        System.out.println(list.stream().filter(string -> !string.equals("Apple")).collect(Collectors.toList()));
        List<String> list2 = Arrays.asList("Nabeel", "Nabeel", "Edition", "Apple1", "Apple2");
        Set<String> combine = new TreeSet<>();
        combine.addAll(list);
        combine.addAll(list2);
        System.out.println(combine);
    }
}
