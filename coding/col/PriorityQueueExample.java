package coding.col;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void findKthLargeValue(int kth) {
        List<Integer> dataFrame = Arrays.asList(12, 5, 87, 45, 32, 87, 2, 99, -1);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer data : dataFrame) {
            queue.offer(data);
            if (queue.size() > kth) {
                queue.poll();
            }
        }
        System.out.println(queue.peek());
    }

    public static void findSecondLargeValue() {
        List<Integer> dataFrame = Arrays.asList(12, 5, 87, 45, 32, 87, 2, 99, -1);
        Integer largeValue = Integer.MIN_VALUE;
        Integer secondValue = Integer.MIN_VALUE;
        for (Integer data : dataFrame) {
            if (data > largeValue) {
                secondValue = largeValue;
                largeValue = data;
            } else if (data > secondValue && data != largeValue) {
                secondValue = data;
            }
        }
        System.out.println(largeValue);
        System.out.println(secondValue);
    }

    public static void findThirdLargeValue() {
        List<Integer> dataFrame = Arrays.asList(12, 5, 87, 45, 32, 87, 2, 99, -1);
        Integer lagValue = Integer.MIN_VALUE;
        Integer secondValue = Integer.MIN_VALUE;
        Integer thirdValue = Integer.MIN_VALUE;
        for (Integer data : dataFrame) {
            if (data > lagValue) {
                thirdValue = secondValue;
                secondValue = lagValue;
                lagValue = data;
            } else if (data > secondValue && data != lagValue) {
                thirdValue = secondValue;
                secondValue = data;
            } else if (data > thirdValue && data != secondValue && data != lagValue) {
                thirdValue = data;
            }
        }
    }

    public static void main(String[] args) {
        findSecondLargeValue();
    }
}
