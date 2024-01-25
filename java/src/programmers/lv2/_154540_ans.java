package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _154540_ans {
    boolean[][] visited;
    int[] dr = {0, 0, -1, 1};
    int[] dc = {-1, 1, 0, 0};
    Queue<Point> q = new LinkedList<>();
    int w, h;
    public int[] solution(String[] maps) {
        int[] answer = {};
        //각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return

        h = maps.length;
        w = maps[0].length();

        List<Integer> list = new ArrayList<>();

        visited = new boolean[h][w];
        int idx = 0;
        boolean flag = false;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(visited[i][j] || maps[i].charAt(j)=='X') continue;
                else {
                    flag = true;
                    list.add(bfs(i, j, maps));
                }
            }
        }

        if(!flag) return new int[]{-1};

        Collections.sort(list);

        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }

    public int bfs(int r, int c, String[] maps){
        q.add(new Point(r, c));
        visited[r][c] = true;
        int sum = maps[r].charAt(c)-'0';

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(nr<0 || nc<0 || nr>=h || nc>=w || visited[nr][nc]) continue;
                if(maps[nr].charAt(nc)=='X') continue;

                visited[nr][nc] = true;
                sum += maps[nr].charAt(nc)-'0';
                q.add(new Point(nr, nc));
            }
        }


        return sum;
    }

    static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
