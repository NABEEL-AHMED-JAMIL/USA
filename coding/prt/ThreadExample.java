package coding.prt;

import static java.lang.Thread.currentThread;

public class ThreadExample  {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("ID of the current thread - " + currentThread().getId());
    }
}
