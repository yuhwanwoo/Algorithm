package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간에서 가장 작은 큰 값을 가지고 풀이
// "임의의 젊은 날의 행복도는 임의의 늙은 날의 행복도보다 높다." 라는 말은
// 젊은 날의 최소 행복도는 늙은 날의 최대 행복도보다는 높음
// "임의의 젊은 날의 피로도는 임의의 늙은 날의 피로도보다 낮다." 라는 말은
// 젊은 날의 최대 피로도는 늙은 날의 최소 피로도보다는 낮음
// 따라서 젊은날의 최소 행복도, 최대 피로도와 늙은날의 최대 행복도, 최소 피로도를 구해야 함
// 젊은날은 입력받은 순으로 순차적으로 구하면 되며, 늙은날은 그 역순으로 구함

public class _18866_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N];
        int[] s = new int[N];
        int[] youthH = new int[N];
        int[] oldH = new int[N];
        int[] youthS = new int[N];
        int[] oldS = new int[N];

        int maxH = -1, minH = Integer.MAX_VALUE, maxS = -1, minS = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            if(h[i] != 0 && h[i] < minH) minH = h[i];
            if(s[i] != 0 && s[i] > maxS) maxS = s[i];
            youthH[i] = minH;
            youthS[i] = maxS;
        }

        for(int i = N-1; i >= 0; i--) {
            if(h[i] != 0 && h[i] > maxH) maxH = h[i];
            if(s[i] != 0 && s[i] < minS) minS = s[i];
            oldH[i] = maxH;
            oldS[i] = minS;
        }

        int K = -1;
        for(int k = 0; k < N - 1; k++) {
            if(youthH[k] > oldH[k+1] && youthS[k] < oldS[k+1]) K = k;
        }
        System.out.println(K == -1 ? K : K+1);
    }
}
