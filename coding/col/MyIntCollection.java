package coding.col;

import java.util.Iterator;

public class MyIntCollection implements Iterable<Integer> {

    private int[] numbers;

    public MyIntCollection(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIntIterator();
    }

    private class MyIntIterator implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < numbers.length;
        }

        @Override
        public Integer next() {
            return numbers[index++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40};
        MyIntCollection myIntCollection = new MyIntCollection(nums);
        for(int num: myIntCollection) {
            System.out.println(num);
        }
    }

}
