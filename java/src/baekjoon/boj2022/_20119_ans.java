package baekjoon.boj2022;

import java.util.*;
import java.io.*;

public class _20119_ans {
    static int N, M, size;
    static int[] count, targetNum;
    static ArrayList<Integer>[] list;
    static Stack<Integer> stack = new Stack();
    static HashSet<Integer> hs = new HashSet();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        init();

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            count[idx] = (size = stoi(st.nextToken()));
            for (int i = 0; i < size; i++) {
                list[stoi(st.nextToken())].add(idx);

            }
            targetNum[idx] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        size = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            stack.add(stoi(st.nextToken()));
            hs.add(stack.peek());
        }

        topology();

        System.out.println(findResult());
    }

    private static void topology() {
        while (!stack.isEmpty()) {
            int now = stack.pop();
            for (int next : list[now]) {
                if (--count[next] == 0 && !hs.contains(targetNum[next])) {
                    hs.add(targetNum[next]);
                    stack.add(targetNum[next]);
                }
            }
        }
    }

    private static String findResult() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(hs);
        size = pq.size();
        while (!pq.isEmpty()) {
            sb.append(pq.poll() + " ");
        }
        return size + "\n" + sb.toString();
    }

    private static void init() {
        targetNum = new int[M];
        count = new int[M];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }

}
