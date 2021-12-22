package test.eTest;

import java.util.HashMap;

public class exam01 {
    public static void main(String[] args) {
        //String[] scores = {"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"};
        String[] scores = {"BCD","ABB","FEE"};

        solution(scores);
    }

    public static int solution(String[] scores) {
        int answer = 0;

        int t = scores.length;
        int dir = scores[0].length();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 5);
        map.put('B', 4);
        map.put('C', 3);
        map.put('D', 2);
        map.put('E', 1);
        map.put('F', 0);

        for (int i = 0; i < t; i++) {

            String now = scores[i];

            int Acnt = 0;
            int Fcnt = 0;
            int sum = 0;
            boolean flag = false;

            for (int j = 0; j < dir; j++) {
                char key = now.charAt(j);
                if (key == 'F') {
                    Fcnt += 1;
                }
                if (key == 'A') {
                    Acnt += 1;
                }
                sum += map.get(key);
            }
            System.out.println(now);

            if (Fcnt >= 2) {
                continue;
            }
            if (Acnt >= 2){
                answer += 1;
                continue;
            }

            if (sum/dir >= 3 ){
                answer += 1;
            }
        }

        return answer;
    }
}
