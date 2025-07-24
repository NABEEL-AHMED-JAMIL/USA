package coding.prt;

public class ThreadExample4 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
           try {
               Thread.sleep(1000); // Enters TIMED_WAITING
           } catch (Exception ex) {
               System.out.println("Thread Execute Intreupt");
           }
        });
        // New
        System.out.println("State after creation: " + thread.getState());
        // Running and Runnable State
        thread.start();
        System.out.println("State after creation: " + thread.getState());
        // 3. TIMED_WAITING (during sleep inside thread)
        Thread.sleep(500); // Wait to catch it while sleeping
        System.out.println("State during sleep(): " + thread.getState());
        // 4. TERMINATED
        thread.join(); // Wait for thread to finish
        System.out.println("Final state after completion: " + thread.getState());
    }
}
