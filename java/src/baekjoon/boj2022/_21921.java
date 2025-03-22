package baekjoon.boj2022;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class _21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] prefix = new int[n + x];

        //1 4 2 5 1
        //0 0 0 0 0 0 0
        //0 0 1 5 7 12 13

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            prefix[i + x] = arr[i] + prefix[i + x - 1];
//            System.out.print("prefix = " + prefix[i + x] + " ");
            if (i >= x - 1) {
                int totalVisitor = prefix[i + x] - prefix[i];
                pq.add(-totalVisitor);
            }
        }

        int answer = 0;

        Integer biggestValue = pq.peek();

        if (biggestValue == 0) {
            System.out.println("SAD");
            return;
        }

        for (int i = 0; i < pq.size(); i++) {
            Integer top = pq.poll();
            if (top == biggestValue) {
                answer += 1;
            } else {
                break;
            }
        }

        System.out.println(-biggestValue);
        System.out.println(answer);
    }
}
