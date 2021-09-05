import java.util.LinkedList;
import java.util.Queue;

public class lv3_67259 {
    public static void main(String[] args) {
//        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};

        int[][] board = {{0, 0, 0, 0, 0},{0, 1, 1, 1, 0},{0, 0, 1, 0, 0},{1, 0, 0, 0, 1},{0, 1, 1, 0, 0}};

        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int size = board.length;

        int[][] co_board = new int[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                co_board[i][j] = 1000000;
            }
        }


        Queue<Build> q = new LinkedList<>();

        q.add(new Build(0, 0, 1, 0));
        q.add(new Build(0, 0, 2, 0));

        while (!q.isEmpty()) {
            Build build = q.poll();
            if (build.x == size -1 && build.y == size -1) {
                answer = Math.min(answer, build.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = build.x + dx[i];
                int ny = build.y + dy[i];
                int cost = 0;
                if (nx < 0 || ny < 0 || nx >= size || ny >= size || board[nx][ny] == 1) {
                    continue;
                }
                if (build.dir + 2 == i || build.dir - 2 == i) {
                    continue;
                }
                if (build.dir == i) {
                    cost = 100;
                }else {
                    cost = 600;
                }
                if (co_board[nx][ny] >= build.cost + cost) {
                    co_board[nx][ny] = build.cost + cost;
                    q.add(new Build(nx, ny, i, build.cost + cost));
                }
            }
        }

        return answer;
    }
}

class Build {
    int x, y, dir, cost;

    public Build(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}
