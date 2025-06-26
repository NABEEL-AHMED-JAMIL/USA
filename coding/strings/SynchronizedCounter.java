package coding.strings;

public class SynchronizedCounter {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void increment() {
        count = count + 1;
    }
}
