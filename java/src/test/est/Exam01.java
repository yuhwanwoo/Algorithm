package test.est;

public class Exam01 {
    public static void main(String[] args) {
        int[][] histogram = {{0,0,0,0,0,0,1}, {0,0,0,1,0,0,1}, {0,1,0,1,0,0,1}, {1,1,2,2,1,0,1},{2,2,2,2,1,2,2}, {2,2,1,1,1,2,2}, {2,2,1,1,1,2,2}};
        solution(histogram);
    }

    public static int solution(int[][] histogram) {
        int answer = 1;
        boolean firstFlag;
        int cnt;
        for (int i = 0; i < histogram[0].length; i++) {
            firstFlag = false;
            cnt = 0;
            for (int j = 0; j < histogram.length; j++) {
                int now = histogram[j][i];
                if (firstFlag && now == 0) {
                    firstFlag = false;
                    cnt = 1;
                    continue;
                }
                if (!firstFlag && now == 0) {
                    cnt = 1;
                    continue;
                }
                if (now == 1 && !firstFlag) {
                    cnt = 1;
                    break;
                }
                if (now == 2) {
                    firstFlag = true;
                    cnt += 1;
                }
                if (now == 1 && firstFlag) {
                    cnt += 1;
                    break;
                }
                if (j == histogram.length - 1) {
                    cnt += 1;
                }
            }
            answer *= cnt;
            System.out.println("answer = " + answer);
        }
        return answer;
    }
}
