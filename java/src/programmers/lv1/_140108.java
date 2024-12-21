package programmers.lv1;

public class _140108 {
    public static void main(String[] args) {
        String s = "banana"; // ba - na - na
        System.out.println("solution(s) = " + solution(s));
        String s1 = "abracadabra"; // ab - ra - ca - da - br - a
        System.out.println("solution(s1) = " + solution(s1));
        String s2 = "aaabbaccccabba"; // aaabbacc - ccab - ba
        System.out.println("solution(s2) = " + solution(s2));
        s2 = "a"; // aaabbacc - ccab - ba
        System.out.println("solution(s2) = " + solution(s2));
    }

    public static int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int answer = 0;

        int sameCnt = 1;
        int diffCnt = 0;
        char first = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (first == s.charAt(i)) {
                sameCnt += 1;
            } else {
                diffCnt += 1;
            }

            if (sameCnt == diffCnt) {
                answer += 1;
                if (i == s.length() - 1) {
                    break;
                }
                first = s.charAt(i + 1);
                sameCnt = 0;
                diffCnt = 0;
            } else {
                if (i == s.length() - 1) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
