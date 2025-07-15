package coding.strings;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BasicCode {

    public static Map<Character, Integer> countDuplicateCharactersV1(String str) {
        if (str == null || str.isBlank()) {
            return Collections.EMPTY_MAP;
        }
        // character
        Map<Character, Integer> result = new HashMap<>();
        for(char ch: str.toCharArray()) {
            result.compute(ch, (k, v) -> v==null ? 1: ++v);
        }
        return result;
    }

    // chaMap.compute(ch, (k, v) -> value)
    public static Map<String, Integer> countDuplicateCharactersV2(String str) {
        if (str == null || str.isBlank()) {
            return Collections.EMPTY_MAP;
        }
        // code of char
        Map<String, Integer> result = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.charCount(cp));
            if (Character.charCount(cp) == 2) {
                i++;
            }
            result.compute(ch, (k, v) -> v==null ? 1: ++v);
        }
        return result;
    }

    // Collectors.groupingBy => k -> k, value
    public static Map<Character, Long> countDuplicateCharactersV3(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }
        // IntStream => Integer Stream
        Map<Character, Long> result = str.chars()
            .mapToObj(ch -> (char) ch)
            .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
        return result;
    }

    // Collectors.groupingBy => k -> k, value
    public static Map<String, Long> countDuplicateCharactersV4(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<String, Long> result = str.codePoints()
            .mapToObj(ch -> String.valueOf(Character.toChars(ch)))
            .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
        return result;
    }

    // 'ApAule' => 'p' will be the N-Repeated first char
    // 'Apple' => 'A' will be the N-Repeated first char
    public static char firstNonRepeatedCharacterV1(String str) {
        if (str == null || str.isBlank()) {
            return Character.MIN_VALUE;
        }
        for (int i=0; i<str.length(); i++) {
            int count = 0;
            char ch = str.charAt(i);
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

    // chaMap.compute(ch, (k, v) -> value)
    public static char firstNonRepeatedCharacterV2(String str) {
        if (str == null || str.isBlank()) {
            return Character.MIN_VALUE;
        }
        Map<Character, Integer> chaMap = new LinkedHashMap<>();
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            chaMap.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }
        // get-key
        for (Map.Entry<Character, Integer> entry: chaMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }

    public static String reverseStringV1(String str) {
        if (str == null && str.isEmpty()) {
            return "";
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static final String WHITE_SPACE = " ";
    public static String reverseStringV2(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] worlds = str.split(WHITE_SPACE);
        StringBuffer reversedString = new StringBuffer();
        for (String world : worlds) {
            StringBuffer reverseWord = new StringBuffer();
            for (int i=world.length(); i>=0; i--) {
                reverseWord.append(world.charAt(i));
            }
            reversedString.append(reverseWord).append(WHITE_SPACE);
        }
        return reversedString.toString();
    }

    // Collectors.joining(WHITE_SPACE)
    public static final Pattern PATTERN = Pattern.compile(" +");
    public static String reverseStringV3(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return PATTERN.splitAsStream(str)
            .map(w -> new StringBuffer(w).reverse())
            .collect(Collectors.joining(WHITE_SPACE));
    }

    public static boolean containsOnlyDigitsV1(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i=0; i<str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyDigitsV2(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^\\d+$");
    }

    // AbstractMap.SimpleEntry<>(0, 0)
    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public static Map.Entry<Integer, Integer> countVowelsAndConsonantsV1(String str) {
        if (str == null || str.isEmpty()) {
            return new AbstractMap.SimpleEntry<>(0, 0);
        }
        str = str.toLowerCase();
        int vowel = 0;
        int consonants = 0;
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowel++;
            } else if (ch >= 'a' && ch <= 'z'){
                consonants++;
            }
        }
        return new AbstractMap.SimpleEntry<>(vowel, consonants);
    }

    // Collectors.partitioningBy(ch -> ch, counter)
    // new AbstractMap.SimpleEntry<>(0, 0)
    public static Map.Entry<Integer, Integer> countVowelsAndConsonantsV2(String str) {
        if (str == null || str.isEmpty()) {
            return new AbstractMap.SimpleEntry<>(0, 0);
        }
        str = str.toLowerCase();
        Map<Boolean, Long> chountMap = str.chars()
           .mapToObj(ch -> (char) ch)
           .filter(ch -> ch >= 'a' && ch <= 'z')
            .collect(Collectors.partitioningBy(ch -> allVowels.contains(ch), Collectors.counting()));
        return new AbstractMap.SimpleEntry<>(chountMap.get(true).intValue(), chountMap.get(false).intValue());

    }

    // '\0' refer to null
    public static int countOccurrencesOfACertainCharacterV1(String str, char ch) {
        if (ch == '\0') return -1;
        // nabeel - nabl = 2e
        return str.length() - str.replaceAll(String.valueOf(ch), "").length();
    }

    public static int countOccurrencesOfACertainCharacterV2(String str, char ch) {
        if (ch == '\0') return -1;
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static int countOccurrencesOfACertainCharacterV3(String str, char ch) {
        if (ch == '\0') return -1;
        return (int) str.chars().filter(value -> ch == (char) value).count();
    }

    /**
     * \S	  any single non-whitespace character
     * \S+	  a sequence of non-whitespace characters
     * ^\S+$  a line with no spaces at all
     * */
    public static String removeWhitespaces(String str) {
        if (str == null || str.isEmpty()) return "";
        return str.replaceAll("\\s", "");
    }

    public static String joinByDelimiterV1(char delimiter, String... args) {
        if (args == null || args.length == 0) return "";
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(delimiter);
        }
        result.append(args[i]);
        return result.toString();
    }

    public static String joinByDelimiterV2(String delimiter, String... args) {
        if (args == null || args.length == 0) return "";
        return Arrays.stream(args, 0, args.length).collect(Collectors.joining(delimiter));
    }

    public static String joinByDelimiterV3(String delimiter, String... args) {
        if (args == null || args.length == 0) return "";
        StringJoiner joiner = new StringJoiner(delimiter);
        for (String arg : args) {
            joiner.add(arg);
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        // System.out.println(firstNonRepeatedCharacterV1("Apple")); // out-put valid 'A'
        // System.out.println(firstNonRepeatedCharacterV1("pAple")); // out-put valid 'A'
        // System.out.println(firstNonRepeatedCharacterV1("AppAee")); // out-put non
    }

}
