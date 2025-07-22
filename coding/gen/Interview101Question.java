package coding.gen;

import java.util.*;
import java.util.stream.Collectors;

public class Interview101Question {

    // How to reverse a string in java
    public static void reverseStr() {
        int index = 0;
        String reverse = "reverse";
        char[] charRev = new char[reverse.length()];
        for (int i = reverse.length()-1; i>=0; i--) {
            charRev[index] = reverse.charAt(i);
            index++;
        }
        System.out.println(charRev);
    }

    /**
     * V.V IMP Question
     * */
    public static void pyramidPattern() {
        int pyramidSize = 5;
        for (int i=0; i<pyramidSize; i++) {
            for (int j=0; j<pyramidSize-i; j++) {
                System.out.print(" ");
            }
            for (int k=0; k<=i; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    public static void removeAllWhiteSpaces() {
        String whiteSpace = " ";
        String text = "asdf sadfasdf asdfs   sdfsdfasdfa   ";
        StringBuilder newText = new StringBuilder();
        for (String tx : text.split(whiteSpace)) {
            if (tx.trim().length() != 0) {
                newText.append(tx.trim()).append(whiteSpace);
            }
        }
        text = newText.toString().trim();
        System.out.println(text);
    }

    public static void duplicateCharacter() {
        String str = "sadfasdf";
        Map<Character, Integer> duplicateCh = new HashMap<>();
        for (char ch : str.toCharArray()) {
            // point
            duplicateCh.put(ch, duplicateCh.getOrDefault(ch, 0)+1);
        }
        System.out.println(duplicateCh);
    }

    /**
     * V.V IMP Question
     * */
    public static void equalityTwoArrays() {
        int[] array1 = { 1, 2, 3, 4, 5 };
        int[] array2 = { 1, 1, 3, 4, 5 };
        boolean isEqual = false;
        if (array1.length == array2.length) {
            isEqual = true;
            for (int i=0; i<array1.length; i++) {
                if (array1[i] != array2[i]) {
                    isEqual = false;
                    break;
                }
            }
        }
        if (isEqual) {
            System.out.println("Equality");
        } else {
            System.out.println("No Equality");
        }
    }

    /**
     * V.V IMP Question
     * */
    public static void anaGramArray() {
        String text1 = "Mother In Law";
        String text2 = "Hitler Woman";
        List<Character> textArray1 = text1.chars()
            .filter(value -> !Character.isWhitespace(value))
            .mapToObj(value -> Character.toLowerCase((char) value))
            .sorted(Character::compareTo).toList();
        List<Character> textArray2 = text2.chars()
            .filter(value -> !Character.isWhitespace(value))
            .mapToObj(value -> Character.toLowerCase((char) value))
            .sorted(Character::compareTo).toList();
        System.out.println(textArray1.equals(textArray2) ? "AnaGram": "No Anagram");
    }

    /**
     * V.V IMP Question
     * */
    public static void sumAllDigits() {
        String text = "7456";
        int sum = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isDigit(ch)) {
                // point
                sum += Character.getNumericValue(ch);
            }
        }
        System.out.println(sum);
    }

    /**
     * V.V IMP Question
     * */
    public static void sumAllDigitsV1() {
        Integer number = 7456;
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        System.out.println("Sum " + sum);
    }

    /**
     * V.V IMP Question
     * */
    public static void pairsArraySum() {
        int targetSum = 20;
        int[] array = { 4, 5, 7, 11, 9, 13, 8, 12 };
        for (int i=0; i<array.length; i++) {
            for (int j=i+1; j<array.length; j++) {
                // (4, 5) = 9
                if (array[i]+array[j] == targetSum) {
                    System.out.println("(" + array[i] + "," + array[j] + ") = " + (array[i]+array[j]) );
                }
            }
        }
    }

    /**
     * V.V IMP Question
     * */
    public static void reverseEach() {
        String WHITE_SPACE = " ";
        String text = "Java Concept Of The Day";
        String array[] = text.split(WHITE_SPACE);
        StringBuilder newText = new StringBuilder();
        for (int indxe=0; indxe<array.length; indxe++) {
            StringBuilder subarray = new StringBuilder(array[indxe]);
            if (indxe == array.length-1) {
                newText.append(subarray.reverse());
            } else {
                newText.append(subarray.reverse()).append(WHITE_SPACE);
            }
        }
        System.out.println(newText);
    }

    /**
     * V.V IMP Question
     * */
    public static void sortHashMapByValue() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("David", 95);
        scores.put("Jane", 80);
        scores.put("Mary", 97);
        scores.put("Lisa", 78);
        scores.put("Dino", 65);
        // we use linkHaspMap
        Map<String, Integer> sc2 = scores.entrySet().stream().sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sc2);
    }

    public static void main(String[] args) {
        reverseEach();
    }
}
