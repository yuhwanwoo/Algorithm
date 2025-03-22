package programmers.lv3;

import java.util.Arrays;

public class _152995_ans {
    public static void main(String[] args) {

    }

    public int solution(int[][] scores) {
        int[] base = scores[0];
        Arrays.sort(scores, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            else
                return b[0] - a[0];
        });

        int baseSum = base[0] + base[1];
        int answer = 1;
        int prev = 0;

        // [a,b] 형태의 점수.
        // a는 감소하는순, b는 증가하는 순
        for(int[] data : scores){
            // b가 이전보다 작다.
            // 즉 a,b가 모두 작아지는 경우이므로 탈락자.
            if(prev > data[1]){
                // 완호의 점수가 탈락자인 경우
                if(data[0] == base[0] && data[1] == base[1])
                    return -1;
            } else {
                prev = data[1];
                if(data[0] + data[1] > baseSum)
                    answer++;
            }
        }
        return answer;
    }
}
