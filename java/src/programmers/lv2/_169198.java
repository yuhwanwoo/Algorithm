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
        int t = 0;
        for (int i = 0; i < balls.length; i++) {
            int min = Integer.MAX_VALUE;
            int x = balls[i][0];
            int y = balls[i][1];
            //todo min 계산 식 변경해야함

            // y가 같으면서 x가 startX보다 크면안됨
            /*
            (startY-t)x = startX(t-y)
            x*startY-tx = t*startX-y*startX
            t(startX+x) = x*startY + y * startX
            t = (x*startY + y* startX)/(startX+x)
             */
            if (!(y == startY && startX > x)) {
                t = (x * startY + y * startX) / (startX + x);
                min = Math.min(startX * startX + (startY - t) * (startY - t), min);
            }
            /*
            (t, n)
            (t-startX)/(n-startY) = (x-t)/(n-y)
            (t-startX)*(n-y) = (x-t)(n-startY)

             */

            if (!(x == startX && startY > y)) {
                t = (n * x - x * startY + n * startX - y * startX) / (2 * n - y - startY);
//                min = Math.min((t- startX))
            }


            answer[i] = min;
        }
        return answer;
    }
}
