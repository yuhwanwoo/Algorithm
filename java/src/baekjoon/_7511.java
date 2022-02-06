package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class _7511 {

    public static int[] parent = new int[100001];
    static int n, k, m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int scenario = 1;

        while (t != 0){
            n = Integer.parseInt(br.readLine());

            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            k = Integer.parseInt(br.readLine());

            StringTokenizer st;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                unionParent(a, b);
            }

            bw.write("Scenario " + scenario + ":" + "\n");

            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (findParent(u) == findParent(v)) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }

            bw.write("\n");

            scenario += 1;

            t--;
        }

        bw.flush();
        bw.close();
    }

    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
