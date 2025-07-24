package coding.prt;

public class DeadlockExample {

    static class Resource {
    }
    public final Resource resource1 = new Resource();
    public final Resource resource2 = new Resource();

    public void method1() {
        synchronized (resource1) {
            System.out.println(Thread.currentThread().getName() + " locked resource1");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " locked resource2");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        }
    }

    public void method2() {
        synchronized (resource2) {
            System.out.println(Thread.currentThread().getName() + " locked resource2");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locked resource1");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();
        Thread t1 = new Thread(example::method1, "Thread-1");
        Thread t2 = new Thread(example::method2, "Thread-2");
        t1.start();
        t2.start();
    }
}
