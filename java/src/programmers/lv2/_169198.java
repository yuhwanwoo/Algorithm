package programmers.lv2;

public class _169198 {
    public static void main(String[] args) {
        solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}});
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
            if (y == startY && startX > x) {
                int t = (x*startY + y* startX)/(startX+x);
                System.out.println("t = " + t);
                min = Math.min(startX * startX + (startY - t) * (startY - t), min);
            }



            // y가 같으면서 x가 startX보다 크면안됨
            /*
            (startY-t)x = startX(t-y)
            x*startY-tx = t*startX-y*startX
            t(startX+x) = x*startY + y * startX
            t = (x*startY + y* startX)/(startX+x)

             */
        }
        return answer;
    }
}
