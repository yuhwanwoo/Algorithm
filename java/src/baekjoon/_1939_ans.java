package baekjoon;

import java.awt.*;
import java.util.*;
import java.io.*;

public class _1939_ans {
    static int N,M;
    static ArrayList<Point> arrList[];
    static boolean visit[];
    static int begin, end;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrList = new ArrayList[N+1];
        for(int i=0; i<N+1; i++)
            arrList[i] = new ArrayList<>();

        int low = 999999, high = 0;


        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            low = Math.min(low, val);
            high = Math.max(high, val);
            arrList[u].add(new Point(v, val));
            arrList[v].add(new Point(u, val));
        }
        st = new StringTokenizer(br.readLine());
        begin = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        while(low <= high) {
            visit = new boolean[N+1];
            int mid =(low+high)/2;
            if(bfs(mid))
                low = mid+1;
            else
                high = mid-1;
        }
        System.out.println(high);
    }
    private static boolean bfs(int val) {
        // TODO Auto-generated method stub
        Queue<Integer> queue = new LinkedList<Integer>();
        visit[begin] = true;
        queue.add(begin);
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            if(poll == end)
                return true;

            for(int i=0; i<arrList[poll].size(); i++) {
                if(!visit[arrList[poll].get(i).x] && val <= arrList[poll].get(i).y) {
                    visit[arrList[poll].get(i).x] = true;
                    queue.add(arrList[poll].get(i).x);
                }
            }
        }
        return false;
    }
}
