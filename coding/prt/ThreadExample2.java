package coding.prt;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ThreadExample2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // thread1
        Callable<String> thread1 = () -> {
            Thread.sleep(5000);
            return "Result Thread 1";
        };
        // thread2
        Callable<String> thread2 = () -> {
            Thread.sleep(1000);
            return "Result Thread 2";
        };
        // thread3
        Callable<String> thread3 = () -> {
            Thread.sleep(1000);
            return "Result Thread 3";
        };
        // This line submits all tasks at once, and waits for all of them to complete.
        // Even though task2 might finish before task1, and task1 before task3, the futures list preserves the order of the taskList:
        List<Callable<String>> taskList = Arrays.asList(thread1, thread2, thread3);
        List<Future<String>> futures = executorService.invokeAll(taskList);
        for (Future<String> future: futures) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
