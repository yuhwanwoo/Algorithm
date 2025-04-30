package hackerrank;

import java.util.List;
import java.util.PriorityQueue;

public class Mini_Max_Sum {
    public static void main(String[] args) {
        miniMaxSum(List.of(1, 2, 3, 4, 5));
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        PriorityQueue<Long> maxQueue = new PriorityQueue<>();
        PriorityQueue<Long> minQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.size(); i++) {
            maxQueue.add(- (long) arr.get(i));
            minQueue.add((long) arr.get(i));
        }

        long max = 0;
        long min = 0;
        for (int i = 0; i < 4; i++) {
            max += maxQueue.poll();
            min += minQueue.poll();
        }

        System.out.println(min + " " + -max);
    }
}
