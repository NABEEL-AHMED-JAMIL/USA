package coding.strings;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // completableFuture.supplyAsync
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Pakistan Zindabad");
        System.out.println(completableFuture.get());
        // CompletableFuture.runAsync
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        });
        // you don't need the extra -> then applay then applya then con
        System.out.println(future.get());
        //
        CompletableFuture<String> welComText = CompletableFuture.supplyAsync(() -> {
            return "Apple";
        }).thenApply(name -> {
            return "Banana";
        }).thenApply(greeting -> {
            return "greeting";
        });
        System.out.println(welComText.get());

    }
}
