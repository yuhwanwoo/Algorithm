package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> arr = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            arr.add(i);
        }

        boolean flag = true;

        while (arr.size() != 1) {
            if (flag) {
                arr.poll();
                flag = false;
            } else {
                int firstElement = arr.poll();
                arr.add(firstElement);
                flag = true;
            }
        }

        System.out.println(arr.poll());
    }
}
