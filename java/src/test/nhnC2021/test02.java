package test.nhnC2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class test02 {

    public static void main(String[] args) throws IOException {   //프로그램의 시작부
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<String, Integer> hash = new HashMap<>();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] arr = new String[n];

            st = new StringTokenizer(br.readLine());
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                arr[j] = st.nextToken();
                hash.put(arr[j], 0);
            }

            for (int j = 0; j < n; j++) {
                int get_cnt = hash.get(arr[j]);
                if (get_cnt == 0) {
                    cnt += 1;
                    hash.replace(arr[j], 1);
                } else {
                    continue;
                }
                if (m == cnt) {
                    System.out.println(j + 1);
                    break;
                }
            }



        }
    }
}
