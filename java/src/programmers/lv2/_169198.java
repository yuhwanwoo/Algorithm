package programmers.lv2;

public class _169198 {
    public static void main(String[] args) {
        solution(10, 10, 3, 7, new int[][]{
                {7, 7},
                {2, 7},
                {7, 3}
        });
    }

    /*
    가로m
    세로n
     */
    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            int min = Integer.MAX_VALUE;
            int x = balls[i][0];
            int y = balls[i][1];

            // 왼
            if (!(y == startY && startX > x)) {
                min = (int) Math.min(Math.pow(startX + x, 2) + Math.pow(startY - y, 2), min);
            }

            //위
            if (!(x == startX && startY < y)) {
                min = (int) Math.min(Math.pow(n - startY + n - y, 2) + Math.pow(x - startX, 2), min);
            }

            // 오
            if (!(y == startY && startX < x)) {
                min = (int) Math.min(Math.pow(m - x + m - startX, 2) + Math.pow(y - startY, 2), min);
            }
            // 밑
            if (!(x == startX && startY > y)) {
                min = (int) Math.min(Math.pow(y + startY, 2) + Math.pow(x - startX, 2), min);
            }
            System.out.println("min = " + min);
            answer[i] = min;
        }
        return answer;
    }
}
