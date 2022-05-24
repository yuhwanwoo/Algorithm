package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _21944 {

    static Map<Integer, TreeSet<Integer>> algoMap = new HashMap<>();
    static Map<Integer, TreeSet<Integer>> levelMap = new HashMap<>();
    static TreeSet<Integer> wholeList = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        /**
         *  알고리즘 분류 별로 map
         *  전체 알고리즘 리스트
         *  난이도 별
         */
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());


        }

    }

}
