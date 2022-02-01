package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _16562 {

    public static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[n + 1];
        parent = new int[n + 1];

        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            unionParent(v, w);
        }

        for (int i = 1; i < n + 1; i++) {
            int parent = findParent(i);
            int price = arr[i];
            if (!map.containsKey(parent)) {
                map.put(parent, 10000);
            }
            if (map.get(parent) > price) {
                map.put(parent, price);
            }
        }

        int sum = 0;

        for(int key : map.keySet()) {
            sum += map.get(key);
        }

        if (sum <= k) {
            System.out.println(sum);
        }else{
            System.out.println("Oh no");
        }


    }

    // 특정 원소가 속한 집합을 찾기
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
