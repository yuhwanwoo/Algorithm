package test.tren;

import java.util.PriorityQueue;

public class exam01 {
    public static void main(String[] args) {
        int N = 2613;

        solution(N);

    }
    public static int solution(int N) {
        int answer = 0;

        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>();

        int size = 0;

        while (N != 0) {
            minq.add(N % 10);
            maxq.add(-(N % 10));
            size += 1;
            N /= 10;
        }
        int carry = 0;
        int mul = 1;


        for (int i = 0; i < size; i++) {
            int min = minq.poll();
            int max = -maxq.poll();

            int sum  = min + max + carry;

            if((sum) >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            answer += (mul * sum);
            mul *= 10;
        }

        if (carry == 1) {
            answer += (mul * carry);
        }

        return answer;
    }
}
