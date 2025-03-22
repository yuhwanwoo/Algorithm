package test.kb;

public class exam01 {
    public static void main(String[] args) {
        int[][] fees = {{200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435}};
        int usage = 320;

//        int[][] fees = {{200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435}};

        solution(fees, usage);
    }


    public static int solution(int[][] fees, int usage) {
        int answer = 0;

        int range_fee = usage;
        int pre_cost = 0;

        for (int i = 0 ; i < fees.length; i++) {
            // 마지막일 때 고려
            int[] now = fees[i];
            if (usage <= now[0] || i == (fees.length - 1)) { // 범위 안
                answer += now[1];
                answer += ((usage - pre_cost) * now[2]);
                break;
            } else { // 범위 밖
                answer += ((now[0] - pre_cost) * now[2]);
                pre_cost = now[0];
            }
        }

        System.out.println(answer);
        return answer;
    }
}
