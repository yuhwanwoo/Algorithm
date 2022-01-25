package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 일단 투포인터,부분합 등
public class _18866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] happiness = new int[n];
        int[] fatigue = new int[n];

        int Hmax = 0;
        int Hmin = Integer.MAX_VALUE;
        int Fmax = 0;
        int Fmin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            happiness[i] = u;
            fatigue[i] = v;
            Hmax = Math.max(Hmax, u);
            Hmin = Math.min(Hmin, u);
            Fmax = Math.max(Fmax, v);
            Fmin = Math.min(Fmin, v);
        }

        int[] MinHappiness = new int[n];
        int[] MaxHappiness = new int[n];
        int[] MinFatigue = new int[n];
        int[] MaxFatigue = new int[n];

        MinHappiness[0] = happiness[0];
        MaxHappiness[n - 1] = happiness[n - 1];
        MaxFatigue[0] = fatigue[0];
        MinFatigue[n - 1] = fatigue[n - 1];

        // 0 처리 어떻게..?


        for(int i = 1; i < n; i++) {
            MinHappiness[i] = Math.min(happiness[i - 1], happiness[i]);
            MaxHappiness[n - 1 - i] = Math.max(happiness[n - i], happiness[n - 1 - i]);
            MaxFatigue[i] = Math.max(fatigue[i - 1], fatigue[i]);
            MinFatigue[n - 1 - i] = Math.min(fatigue[n - i], fatigue[n - 1 - i]);
        }

        int vday = 0;
        int uday = 0;

        for (int i = 0; i < n; i++) {
            if (MaxFatigue[i] > MinFatigue[i]) {
                uday = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (MinHappiness[i] < MaxHappiness[i]) {
                vday = i;
                break;
            }
        }

        System.out.println(vday + " " + uday);


    }
}
