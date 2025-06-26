package coding.strings;

import java.util.concurrent.*;

public class ThreadsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> result = () -> {
            Thread.sleep(5000);
            return "Hello from Callable";
        };
        long startTime = System.nanoTime();
        Future<String> future = executorService.submit(result);
        while (!future.isDone()) {
            System.out.println("Data Process.......");
            double elapsedTimeInSec = (System.nanoTime() - startTime)/1000000000.0;
            if(elapsedTimeInSec > 1) {
                future.cancel(true);
            }
        }
        String output = future.get();
        System.out.println(output);
        executorService.shutdown();
    }
}
