package baekjoon;

import java.io.*;
import java.util.*;


public class _9421 {
    static boolean[] PrimeFlag = new boolean[1000000];
    static ArrayList<Integer> Primes = new ArrayList<>();
    static boolean[] sang = new boolean[1000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> answer = new ArrayList<>();

        int size = 0;

        for (int i = 2; i < n; i++) {
            if (!PrimeFlag[i]) {
                Primes.add(i);
                size += 1;
                for(int j = i *2 ; j < n; j += i){
                    PrimeFlag[j] = true;
                }
            }
        }

        for(int i = 0; i < size; i++) {
            int now = Primes.get(i);
            if(sanggeun(now)) {
                sang[now] = true;
                answer.add(now);

            }
        }

        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

    }

    public static boolean sanggeun(int now) {
        boolean[] visited = new boolean[500];

        String str = Integer.toString(now);
        while(true) {
            if(str.equals("1")) {
                return true;
            }
            int sum = 0;
            for(int i = 0; i < str.length(); i++){
                int tmp = str.charAt(i) - '0';
                sum += (tmp * tmp);
            }

            if(visited[sum]) {
                break;
            }else{
                visited[sum] = true;
            }
            if(sang[sum]) {
                return true;
            }
            str = sum + "";
        }

        return false;
    }
}
