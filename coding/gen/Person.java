package coding.gen;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private int age;
    private String city;

    Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return name + "(" + age + ", " + city + ")";
    }

    /*
       Group can be used with 1 and 2 param keep it mind
       Collectors.groupingBy -> 1, 2 filed
       Collectors.counting
       Collectors.mapping -> 2 filed
     * */
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 23, "New York"),
            new Person("Bob", 31, "Los Angeles"),
            new Person("Charlie", 29, "New York"),
            new Person("David", 35, "Chicago"),
            new Person("Eve", 22, "Los Angeles"),
            new Person("Frank", 28, "New York"),
            new Person("Grace", 33, "Chicago"),
            new Person("Heidi", 27, "Los Angeles"),
            new Person("Ivan", 40, "Chicago"),
            new Person("Judy", 19, "New York")
        );
        // by city
        Map<String, List<Person>> byCity = people.stream()
            .collect(Collectors.groupingBy(Person::getCity));
        System.out.println(byCity);
        // by age
        Map<Integer, List<Person>> byAge = people.stream()
            .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(byAge);
        // v.v-imp
        Map<String, Long> countByCity = people.stream()
            .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        System.out.println(countByCity);
        // [city -> [name, name2m name3]]
        Map<String, List<String>> nameOfCity = people.stream()
            .collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(nameOfCity);
        // Group by age -> (Young/Old)
        Map<String, List<Person>> groupAge = people.stream()
            .collect(Collectors.groupingBy(person -> person.getAge() < 30 ? "Young": "Old"));
        System.out.println(groupAge);
        // Group by age
        Map<String, Map<Integer, List<Person>>> groupByAge = people.stream()
            .collect(Collectors.groupingBy(o -> o.getCity(), Collectors.groupingBy(Person::getAge)));
        System.out.println(groupByAge);
    }
}
