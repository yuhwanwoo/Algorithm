package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class _87390_ans {
    public static void main(String[] args) {
        solution(3,2,5); // 3,2,2,3
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = {};
        /*
        1 2 3 4 5
        2 2 3 4 5
        3 3 3 4 5
        4 4 4 4 5
        5 5 5 5 5

        1 2 3
        2 2 3
        3 3 3
         */

        return answer;
    }

    public int[] solution2(int n, long left, long right) {
        List <Long> list = new ArrayList<>();
        long cnt = left / n * n;
        for(long i = left / n; i < n; i++) {
            if(cnt > right) break;
            for(long j = 0; j < n; j++) {
                if(cnt > right) break;
                if(cnt >= left)
                    list.add(Math.max(i, j) + 1);
                cnt++;
            }
        }
//        return list.;
//        return list.stream().map(Long::intValue);
        return null;
    }
}
