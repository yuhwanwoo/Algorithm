package programmers.year2023.lv1;

public class _161989 {
    public static void main(String[] args) {
//        int n = 8;
//        int m = 4;
//        int[] section = {2,3,6};

//        int n = 5;
//        int m = 4;
//        int[] section = {1,3};

//        int n = 4;
//        int m = 1;
//        int[] section = {1,2,3,4};
//        int n = 8;
//        int m = 4;
//        int[] section = {2,4,5};

        int n = 8;
        int m = 4;
        int[] section = {2,4,6,8};
        System.out.println(solution(n, m, section));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int start = 0;

        while (start < section.length) {
            answer += 1;
            int maxPaint = section[start] + m - 1; // 현재 기준 최대 페인트 칠 장소
            if (maxPaint >= n) {
                break;
            }
            for (int i = start; i < section.length; i++) {
                int now = section[i];
                if (now > maxPaint) {
                    start = i;
                    break;
                }
                if (i == section.length - 1) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
