package coding.col;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListCollectionExam {

    public static void main(String[] args) throws InterruptedException {
        ListCollectionExam collectionExam = new ListCollectionExam();
        collectionExam.arrayListThreadExam();
        System.out.println("Main Thread Finish.");
    }

    public void arrayListExam() {
        /**
         * ArrayList maintains insertion order.
         * Allow duplicate elements.
         * Index base access like arrays.
         * Resized dynamically
         * */
        List<String> fruits = new ArrayList<>();
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        //
        System.out.println("First Fruit: " + fruits.get(0));
        // for each
        for (String fruit: fruits) {
            System.out.println(fruit);
        }
        // updating an element
        fruits.set(1, "Blueberry");
        // removing an element
        fruits.remove("Mongo");
        //===============================================
        /**
         * No need for manual synchronization during reading or writing
         * its makes a new copy of the list on every write
         * good for reading its very fast
         * */
        List<String> safeList = new CopyOnWriteArrayList<>();
        safeList.add("Apple");
        safeList.add("Banana");
        //===============================================
        // Best when you do a lot of adding/removing elements.
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.iterator()
        .forEachRemaining(iter -> {
            System.out.println(iter);
        });
    }

    // A real-world multithreading example with ArrayList crashing
    // CopyOnWriteArrayList working perfectly in multithreading
    public void arrayListThreadExam() throws InterruptedException {
        // Sometimes it works, but sometimes the size will NOT be 2000 ❗
        // Data may get corrupted or exceptions can occur.
        //List<Integer> data = new ArrayList<>();
        //this.demoThreadForArray(data);

        /**
         * its mean CopyOnWriteArrayList correct in multithreading
         * Always correct. No crash. No corruption.
         * */
        //List<Integer> data2 = new CopyOnWriteArrayList();
        //this.demoThreadForArray(data2);

        // Data may get corrupted or exceptions can occur.
        //List<Integer> data3 = new LinkedList<>();
        //this.demoThreadForArray(data3);

        // Always correct. No crash. No corruption.
        List<Integer> data4 = new ArrayList<>();
        this.demoThreadForArray(data4);
    }

    public void demoThreadForArray(List<Integer> data) throws InterruptedException {
        Runnable task = () -> {
            for (int i=0; i<1000; i++) {
                data.add(i);
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        // task-1 start & task-2
        // it's makes the main thread wait until the child thread end.
        t1.start();
        t2.start();
        // wait to stop the
        t1.join();
        t2.join();
        System.out.println("List size: " + data.size());
    }

}
