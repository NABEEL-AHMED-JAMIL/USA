package coding.gen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        // simple stream
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Alice");
        List<Integer> numbers = Arrays.asList(5, 12, 9, 18, 7, 12, 3, 9);
        // 1. Creating Streams
        Stream<String> stream1 = names.stream();
        Stream<Integer> stream2 = numbers.parallelStream();
        // 2. filter element start with 'A'
        List<String> nameAFilter = names.stream().filter(name -> name.startsWith("a")).collect(Collectors.toList());
        System.out.println("Filter names starting with 'A' " + nameAFilter);
        // 3. Mapping element (e.g, uppercase)
        List<String> uppercase = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercase names " + uppercase);
        // 4. Sorting elements
        List<String> sortedName = names.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted names " + sortedName);
        // 5. distinct value
        List<String> distinctName = names.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct names " + distinctName);
        // 6. Limit and Skip
        List<String> limitedName = names.stream().limit(3).collect(Collectors.toList());
        System.out.println("Limit names " + limitedName);
        List<String> skipName = names.stream().skip(3).collect(Collectors.toList());
        System.out.println("Skip names " + skipName);
        // 7. Count elements matching condition
        Long countA = names.stream().filter(name -> name.startsWith("A")).count();
        System.out.println("Count of names starting with A: " + countA);
    }
}
