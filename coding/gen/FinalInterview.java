package coding.gen;

import java.util.*;
import java.util.stream.Collectors;

public class FinalInterview {

    private int[][] matrix = new int[3][4]; // 3 rows, 4 columns
    private String[][] grid = {
        {"A", "B"},
        {"C", "D"}
    };

    public static void printUserInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        System.out.println("User input : " + userInput);
    }

    public static void convertCertainNumber() {
        Character.isDigit('c');
        Character.isWhitespace('c');
        Character.isLowerCase('c');
        Character.isUpperCase('W');
        System.out.println(Integer.valueOf("1265"));
        System.out.println(Integer.parseInt("12655"));
        System.out.println("apple value".replaceAll("\\s", ""));
        System.out.println(String.join(" ", "apple", "banana", "dmp"));
    }

    public static void printJointWithLimitString() {
        List<String> coffee = Arrays.asList("Espresso", "Americano", "Cappuccino", "Latte", "Mocha",
             "Macchiato", "Flat White", "Affogato", "Cortado", "Ristretto",
             "Cold Brew", "Nitro Coffee", "Turkish Coffee", "Irish Coffee", "Vienna Coffee");
        System.out.println(coffee.stream().limit(10).collect(Collectors.joining(",")));
    }

    /**
     * V.V IMP Question
     * */
    public static void iteratorExample() {
        List<String> names = new ArrayList<>(List.of("Alice", "Mike", "Sara"));
        // using iterator we can delete, update, add in the list
        ListIterator<String> listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            String targetName = listIterator.next();
            if (targetName.equals("Alice")) {
                listIterator.set("Nabeel");
            } else {
                listIterator.add("APPle");
            }
        }
        System.out.println(names);
    }

    public static void countCharacter() {
        String inputStr = "iloveusailoveusa";
        int[] chCode = new int[256];
        for (int i=0; i<inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            chCode[ch] = chCode[ch]+1;
        }
        // check the data
        for (int i=0; i<chCode.length; i++) {
            char ch = (char) i;
            int count = chCode[ch];
            if (count >0) {
                System.out.println("Ch " + ch + " Count " + count);
            }
        }
    }

    /**
     * V.V IMP Question
     * */
    public static void countCharacterV1() {
        String inputStr = "iloveusailoveusa";
        Map<Character, Integer> data = new HashMap<>();
        for (char ch : inputStr.toCharArray()) {
            data.compute(ch, ((k, v) -> v == null ? 1 : ++v));
        }
        System.out.println(data);
    }

    public static void countCharacterV2() {
        String inputStr = "iloveusailoveusa";
        Map<Character, Long> data = inputStr.chars()
            .mapToObj(value -> (char) value)
            .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
        System.out.println(data);
    }

    /**
     * V.V IMP Question
     * */
    public static void countDuplicatesCharacter() {
        String inputStr = "iloveuuul";
        Map<Character, Integer> duplicatesCh = new HashMap<>();
        Set<Character> hasDuplicate = new HashSet<>();
        for (char ch : inputStr.toCharArray()) {
            if (duplicatesCh.containsKey(ch)) {
                hasDuplicate.add(ch);
            } else {
                duplicatesCh.compute(ch, (key, value) -> value == null ? 1 : ++value);
            }
        }
        System.out.println(hasDuplicate);
    }

    public static void countDuplicatesCharacterV1() {
        String inputStr = "iloveuuul";
        List<Character> duplicate = inputStr.chars().mapToObj(value -> (char) value)
            .collect(Collectors.groupingBy(character -> character, Collectors.counting()))
            .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey)
            .collect(Collectors.toList());
        System.out.println(duplicate);
    }

    public static void findLargeNumber() {
        long[] arrNum = {12, 41, 159, -58, 466, 10};
        long largeNumber = Long.MIN_VALUE;
        for (long num : arrNum) {
            if (num > largeNumber) {
                largeNumber = num;
            }
        }
        System.out.println("Large Number " + largeNumber);
    }

    /**
     * V.V IMP Question
     * */
    public static void findSecondLargeNumber() {
        long[] arrNum = {12, 41, 159, -58, 466, 10};
        long largeNumber = Long.MIN_VALUE;
        long secondNumber = Long.MIN_VALUE;
        for (long num : arrNum) {
            if (num > largeNumber) {
                secondNumber = largeNumber;
                largeNumber = num;
            } else if (num > secondNumber && num != largeNumber) {
                secondNumber = num;
            }
        }
        System.out.println("Second Large Number " + secondNumber);
    }

    /**
     * V.V IMP Question
     * */
    public static void findThirdLargeNumber() {
        long[] arrNum = {12, 41, 159, -58, 466, 10};
        long largeNumber = Long.MIN_VALUE;
        long secondNumber = Long.MIN_VALUE;
        long thirdNumber = Long.MIN_VALUE;
        for (long num : arrNum) {
            if (num > largeNumber) {
                // swap the value
                thirdNumber = secondNumber;
                secondNumber = largeNumber;
                largeNumber = num;
            } else if (num > secondNumber && num != largeNumber) {
                thirdNumber = secondNumber;
                secondNumber = num;
            } else if (num > thirdNumber && num != secondNumber && num != largeNumber) {
                thirdNumber = num;
            }
        }
    }

    /**
     * V.V IMP Question
     * */
    public static void findKthLargeNumber() {
        long[] arrNum = {12, 41, 159, -58, 466, 10};
        long kthLargeNumber = 3;
        // min heap
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long num : arrNum) {
            minHeap.offer(num);
            if (minHeap.size() > kthLargeNumber) {
                minHeap.poll();
            }
        }
        System.out.println(minHeap.peek());
    }

    /**
     * V.V IMP Question
     * */
    public static void findKthLargeNumberV1() {
        List<Integer> arrNum = Arrays.asList(12, 41, 159, -58, 466, 10);
        Collections.sort(arrNum, Collections.reverseOrder());
        System.out.println(arrNum);
        int kthLargeNumber = 2;
        System.out.println(arrNum.get(kthLargeNumber));
    }

    /**
     * V.V IMP Question
     * */
    public static void findFirstNonRepeatCharV1() {
        String input = "abcdabc";
        Map<Character, Integer> data = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            data.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }
        for (Map.Entry<Character, Integer> entry : data.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }

    /**
     * V.V IMP Question
     * */
    public static void findFirstNonRepeatCharV2() {
        String input = "abcdabc";
        for (int i=0; i<input.length(); i++) {
            int count = 0;
            char ch = input.charAt(i);
            for (int j=0; j<input.length(); j++) {
                if (ch == input.charAt(j) && i != j) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("Non Repeat Ch " + ch);
                break;
            }
        }
    }

    public static void reverseWordsV1() {
        String input = "I love you & you love I";
        System.out.println(new StringBuilder(input).reverse());
    }

    public static boolean containsOnlyDigitsV1() {
        String input = "123123123";
        for (int i=0; i<input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyDigitV2(String str) {
        return str.matches("[0-9]+");
    }

    public static void countVowelsAndConsonantsV1() {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        String input = "abcdefghijklmnopqrstuvwxyz";
        Map<String, Integer> countMap = new HashMap<>(2);
        for (char ch : input.toCharArray()) {
            if (vowels.contains(ch)) {
                countMap.compute("Vowel", (key, value) -> value == null ? 1 : ++value);
            } else {
                countMap.compute("Consonants", (key, value) -> value == null ? 1 : ++value);
            }
        }
        System.out.println(countMap);
    }

    public static void countVowelsAndConsonantsV2() {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        String input = "abcdefghijklmnopqrstuvwxyz";
        int vowel = 0;
        int consonants = 0;
        for (char ch : input.toCharArray()) {
            if (vowels.contains(ch)) {
                vowel++;
            } else {
                consonants++;
            }
        }
        System.out.println(Map.of("Vowel", vowel, "Consonants", consonants));
    }

    /**
     * V.V IMP Question [restrict and skip the extra ch]
     * */
    public static void countVowelsAndConsonantsV3() {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        String input = "abcdefghijklmnopqrstuvwxyz12312";
        int vowel = 0;
        int consonants = 0;
        for (char ch : input.toCharArray()) {
            if (vowels.contains(ch)) {
                vowel++;
            } else if ( ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }
        System.out.println(Map.of("Vowel", vowel, "Consonants", consonants));
    }

    /**
     * V.V IMP Question
     * */
    public static void countOccurrencesOfACertainCharacterV1() {
        String input = "abcdefghijklmnopqrstuvwxyz12312";
        int count = 0;
        char certainCharacter = '1';
        for (char ch : input.toCharArray()) {
            if (ch == certainCharacter) {
                count++;
            }
        }
        System.out.println("Certain Character " + count);
    }

    public static void countOccurrencesOfACertainCharacterV2() {
        String certainCharacter = "1";
        String input = "12312";
        int count = input.length() - input.replace(certainCharacter, "").length();
        System.out.println(count);
    }

    public static void countOccurrencesOfACertainCharacterV3() {
        char certainCharacter = '1';
        String input = "12312";
        int count = (int) input.chars().filter(value -> (char) value == certainCharacter).count();
        System.out.println(count);
    }

    /**
     * V.V IMP Question
     * */
    public static void removeDuplicatesV1() {
        String input = "abcdefghijklmnopqrstuvwxyz12312";
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }

    public static void removeDuplicatesV2() {
        String input = "abcdefghijklmnopqrstuvwxyz12312";
        StringBuilder sb = new StringBuilder();
        Set<Character> chHashSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            // important point
            if (chHashSet.add(ch)) {
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }

    // use stream to distinct
    public static void removeDuplicatesV3() {
        String input = "abcdefghijklmnopqrstuvwxyz12312";
        String newStr = Arrays.asList(input.split(""))
             .stream().distinct().collect(Collectors.joining());
        System.out.println(newStr);
    }

    public static void removeCharacterV1() {
        char ch = 'a';
        String input = "abcdefghijklmnopqrstuvwxyz12312";
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c != ch) {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }

    public static void removeCharacterV2() {
        char ch = 'a';
        String input = "abcdefghijklmnopqrstuvwxyz12312";
        String remainStr = input.chars().filter(c -> c != ch)
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining());
        System.out.println(remainStr);
    }

    public static void findLongStringV1() {
        List<String> strArray = Arrays.asList("apple", "asdfasdfadfa", "adsfadfa", "awe", "awer");
        String largeString = "";
        int maxLength = Integer.MIN_VALUE;
        for (String str : strArray) {
            if (str.length() > maxLength) {
                maxLength = str.length();
                largeString = str;
            }
        }
        System.out.println(String.format("Large [%s]", largeString));
    }

    public static void findSecondLongStringV1() {
        List<String> strArray = Arrays.asList("apple", "asdfasdfadfa", "adsfadfa", "awe", "awer");
        String largeString = "";
        String secondLargeStr = "";
        int largeLength = Integer.MIN_VALUE;
        int secondLargeLength = Integer.MIN_VALUE;
        for (String str : strArray) {
            if (str.length() > largeLength) {
                secondLargeLength = largeLength;
                secondLargeStr = largeString;
                largeLength = str.length();
                largeString = str;
            } else if (str.length() > secondLargeLength && str.length() != largeLength) {
                secondLargeLength = str.length();
                secondLargeStr = str;
            }
        }
        System.out.println(String.format("Second [%s]", secondLargeStr));
    }

    public static void findKthLongStringV2() {
        List<String> strArray = Arrays.asList("apple", "asdfasdfadfa", "adsfadfa", "awe", "awer");
        int kthLong = 1;
        PriorityQueue<Integer> indexHeap = new PriorityQueue<>();
        for (String str : strArray) {
            indexHeap.offer(str.length());
            if (indexHeap.size() > kthLong) {
                indexHeap.poll();
            }
        }
        System.out.println(indexHeap.peek());
    }

    public static void findEvenLengthAndPrint() {
        List<String> strArray = Arrays.asList("apple", "asdfasdfadfa", "adsfadfa", "awe", "awer");
        strArray.stream().filter(str -> str.length() % 2 == 0).forEach(System.out::println);
    }

    public static void employeeWithStream() {
        List<Employee> strArray = Arrays.asList(
            new Employee(1, "Alice", "HR", 50000),
            new Employee(2, "Bob", "Engineering", 75000),
            new Employee(3, "Charlie", "Marketing", 60000),
            new Employee(4, "Diana", "Finance", 65000)
        );
        // group by department
        Map<String, List<Employee>> employeesGroup = strArray.stream()
            .collect(Collectors.groupingBy(Employee::department));
        System.out.println(employeesGroup);
        // group by count
        Map<String, Long> employeesCount = strArray.stream()
            .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        System.out.println(employeesCount);
        //
        // 1) employee who has second-highest salary
        Optional<Employee> highSalary = strArray.stream().sorted(Comparator.comparing(Employee::salary)).findFirst();
        System.out.println(highSalary.get());
//        2) list of employee and sort them by their salary
//        3) highest salary in each department
//        4) average salary in all departments
//        5) Employee who stays in Chennai and sort them by their names
//        6) department who is having maximum number of employee
    }

    public static void main(String[] args) {
        employeeWithStream();
    }
}
