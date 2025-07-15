package coding.col;

import java.util.*;
import java.util.stream.Collectors;

public class Ch1 {

    private int[][] matrix = new int[3][4]; // 3 rows, 4 columns
    private String[][] grid = {
        {"A", "B"},
        {"C", "D"}
    };

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

    public static void iteratorExample() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charling");
        for (String name : names) {
            System.out.println(name);
        }
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.hasNext());
        }
    }

    public static void findKthLargeValue(int kth) {
        List<Integer> dataFrame = Arrays.asList(12, 5, 87, 45, 32, 87, 2, 99, -1);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer data : dataFrame) {
            queue.offer(data);
            if (queue.size() > kth) {
                queue.poll();
            }
        }
        System.out.println(queue.peek());
    }

    public static void findLargeNumber(long[] arr) {
        // its -0x8000000000000000L
        long large_number = Long.MIN_VALUE;
        for (long num: arr) {
            if (num > large_number) {
                large_number = num;
            }
        }
    }

    public static void findLargeNumberV1(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(arr);
    }

    public static void findSecondLargeNumber(long[] arr) {
        long large_number = Long.MIN_VALUE;
        long second_large_number = Long.MIN_VALUE;
        for (long num : arr) {
            if (num > large_number) {
                second_large_number = large_number;
                large_number = num;
            } else if (num > second_large_number && num != large_number) {
                second_large_number = num;
            }
        }
    }

    public static void findSecondLargeNumberV2(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(arr[1]);
    }

    public static void findThirdLargeNumber(long[] arr) {
        long large_number = Long.MIN_VALUE;
        long second_large_number = Long.MIN_VALUE;
        long third_large_number = Long.MIN_VALUE;
        for (long num : arr) {
            if (num > large_number) {
                third_large_number = second_large_number;
                second_large_number = large_number;
                large_number = num;
            } else if (num > second_large_number && num != large_number) {
                third_large_number = second_large_number;
                second_large_number = num;
            } else if (num > third_large_number && num != second_large_number && num != large_number) {
                third_large_number = num;
            }
        }
    }

    public static void findThirdLargeNumberV1(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(arr[2]);
    }

    public static Map<Character, Integer> countDuplicateCharacterV1(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<Character, Integer> result = new HashMap<>();
        for (int i=0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public static Map<Character, Long> countDuplicateCharacterV2(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }
        return str.chars().mapToObj(key -> (char) key)
            .collect(Collectors.groupingBy(key -> key, Collectors.counting()));
    }

    public static char firstNonRepeatedCharacterV1(String str) {
        if (str == null || str.isEmpty()) {
            return Character.MIN_VALUE;
        }
        // abcdabc
        // first iteration will go [abcda] => count = 1
        // 2nd iteration will go [bcdab] => count = 1
        // 3rd iteration will go [cdabc] = count = 1
        // 4th iteration will go [d] = count = 0
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            int count = 0;
            for (int j=0; j<str.length(); j++) {
                if (ch == str.charAt(j) && i != j) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }

    public static char firstNonRepeatedCharacterV2(String str) {
        if (str == null && str.isBlank()) {
            return Character.MIN_VALUE;
        }
        // using the LinkedHashMap for order the key
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }

    public static String reverseWordsV1(String str) {
        if (str == null && str.isBlank()) {
            return "";
        }
        final String WHITE_SPACE = " ";
        String[] words = str.split(WHITE_SPACE);
        StringBuilder reverseWordString = new StringBuilder();
        for (String word: words) {
            StringBuilder reverseWord = new StringBuilder();
            for (int i= words.length - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }
            reverseWordString.append(reverseWord).append(WHITE_SPACE);
        }
        return reverseWordString.toString();
    }

    public static String reverseWordsV2(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean containsOnlyDigitsV1(String str) {
        if (str == null && str.isBlank()) {
            return false;
        }
        for (int i=0; i<str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyDigitV2(String str) {
        if (str == null && str.isBlank()) {
            return false;
        }
        return str.matches("[0-9]+");
    }

    public static String joinByDelimiterV1(char delimiter, String... arg) {
        if (arg == null || arg.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        // we arg.length -1 bz we don't want delimiter
        int i = 0;
        for (i=0; i<arg.length-1; i++) {
            result.append(arg[i]).append(delimiter);
        }
        result.append(arg[i]);
        return result.toString();
    }

    public static String joinByDelimiterV2(char delimiter, String... args) {
        if (args == null || args.length == 0) {
            return "";
        }
        return Arrays.stream(args, 0, args.length)
            .collect(Collectors.joining(String.valueOf(delimiter)));
    }

    public static boolean isPalindromeV1(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }
        int left = 0;
        int right = str.length()-1;
        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeV2(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static String removeDuplicatesV1(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char[] chArrays = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chArrays) {
            // important point
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String removeDuplicatesV2(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char[] chArrays = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Character> chHashSet = new HashSet<>();
        for (char ch : chArrays) {
            // important point
            if (chHashSet.add(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String removeDuplicatesV3(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        // use stream to distinct
        return Arrays.asList(str.split(""))
            .stream().distinct().collect(Collectors.joining());
    }

    public static String removeCharacterV1(String str, char ch) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char[] chArrays = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chArrays) {
            if (c != ch) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String removeCharacterV2(String str, char ch) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return str.chars().filter(c -> c != ch)
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        convertCertainNumber();
    }
}
