package coding.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayListDisplay {

    public static void main(String[] args) {
        // coffees
        List<String> coffees = Arrays.asList(
            "Espresso", "Americano", "Cappuccino",
            "Latte", "Mocha", "Macchiato", "Flat White",
            "Affogato", "Cortado", "Ristretto", "Cold Brew",
            "Nitro Coffee", "Turkish Coffee", "Irish Coffee", "Vienna Coffee"
        );
        // limit
        System.out.println(coffees.stream().limit(10).collect(Collectors.joining(",")));
        // input data
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String userInput = scanner.nextLine();
        System.out.println(userInput);
        // mango
        String mango = "Mango";
        String concatMango = "abc".concat(mango).concat("def") + 47;
        System.out.println(concatMango);
    }
}
