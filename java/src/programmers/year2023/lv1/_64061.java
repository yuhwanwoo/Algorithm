package programmers.year2023.lv1;

import java.util.Stack;

public class _64061 {
    private static Stack<Integer> bucket = new Stack<>();

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        solution(board, moves);
    }
    /*
    어피치 4
    무지 2
    파랭 1
    화난 3
    강아지 5
     */

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;

        for (int move : moves) {
            for (int i = 0; i < size; i++) {
                int now = board[i][move - 1];
                if (now != 0) {
                    board[i][move - 1] = 0;
                    if (bucket.isEmpty() || bucket.peek() != now) {
                        bucket.add(now);
                    } else if (bucket.peek() == now) {
                        bucket.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
