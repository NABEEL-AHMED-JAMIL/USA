package coding.prt;

import java.util.concurrent.*;

public class ParallelApiCallExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Simulate API 1 call
        Callable<String> api1 = () -> {
            // Simulate delay and return result
            Thread.sleep(1000);
            return "Result from API 1";
        };

        // Simulate API 2 call
        Callable<String> api2 = () -> {
            // Simulate delay and return result
            Thread.sleep(1200);
            return "Result from API 2";
        };

        // Submit both tasks
        Future<String> future1 = executor.submit(api1);
        Future<String> future2 = executor.submit(api2);

        // Get results
        String result1 = future1.get();  // blocks until done
        String result2 = future2.get();  // blocks until done

        // Combine results
        String combinedResult = result1 + " + " + result2;
        System.out.println("Combined: " + combinedResult);

        executor.shutdown();
    }
}
