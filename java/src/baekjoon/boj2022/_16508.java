package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _16508 {
    static ArrayList<Book> arr=new ArrayList<>();
    static String str;
    static int[] count=new int[26];
    static int[] select=new int[26];
    static int n,min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<str.length();i++)
            count[str.charAt(i)-'A']++;

        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String title = st.nextToken();

            arr.add(new Book(price,title));
        }

        dfs(0,0);
        System.out.println(min==Integer.MAX_VALUE?-1:min);

        // 완탐으로 하자
    }

    static void dfs(int depth, int total) {
        // n개의 책을 모두 탐색했고, 알파벳을 모두 구했다면 최솟값 갱신
        if(depth==n) {
            if(check())
                min=Math.min(total, min);
            return;
        }

        /*
         * 책을 선택하는 방법에는 두 가지가 있다.
         * 현재 depth 번째의 책을 선택하느냐, 선택하지 않느냐
         */

        /*
         * depth번째의 책을 선택한 경우 depth번째의 책의 제목을 구성하는
         * 알파벳의 배열 값을 모두 1로 변경한 뒤 depth를 1 증가,
         * 총액을 depth번째의 책 가격만큼 증가키기고 재귀호출 한다.
         */
        for(int i=0;i<arr.get(depth).title.length();i++)
            select[arr.get(depth).title.charAt(i)-'A']++;
        dfs(depth+1,total+arr.get(depth).price);

        /*
         * depth번째의 책을 선택하지 않는 경우는
         * 이전에 증가시켰던 배열 값을 모두 초기화 시킨 후, 총액은 이전의 값을 유지한 채로 재귀호출 한다.
         */
        for(int i=0;i<arr.get(depth).title.length();i++)
            select[arr.get(depth).title.charAt(i)-'A']--;
        dfs(depth+1,total);
    }

    // 만들고 싶은 단어의 모든 알파벳이 나왔는지 확인하는 함수
    static boolean check() {
        for(int i=0;i<26;i++)
            if(count[i]>select[i])
                return false;
        return true;
    }

    private static class Book {
        int price;
        String title;

        private Book(int price, String title) {
            this.price = price;
            this.title = title;
        }
    }
}
