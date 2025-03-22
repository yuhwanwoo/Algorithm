package test.bra;

public class Test01 {
    public static void main(String[] args) {

//        int[][] fees = {{200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435}};
//        int usage = 320;

//        int[][] fees = {{200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435}};
//        int usage = 450;

//        int[][] fees = {{1851, 1000, 100}, {0, 2000, 155}};
//        int usage = 1205;

        int[][] fees = {{100, 415, 90}, {250, 1600, 389}, {0, 7000,480}};
        int usage = 530;

        solution(fees, usage);
    }

    private static int solution(int[][] fees, int usage) {
        int answer = 0;
        int preCost = 0;

        for (int i = 0 ; i < fees.length; i++) {
            // 마지막일 때 고려
            int[] now = fees[i];
            if (usage <= now[0] || i == (fees.length - 1)) { // 범위 안
                answer += now[1];
                answer += ((usage - preCost) * now[2]);
                break;
            } else { // 범위 밖
                answer += ((now[0] - preCost) * now[2]);
                preCost = now[0];
            }
        }
        System.out.println("answer = " + answer);

        return answer;
    }
}
