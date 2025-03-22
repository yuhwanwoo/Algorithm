package programmers.year2023.lv1;

public class _140108 {
    public static void main(String[] args) {
//        String s = "banana";

//        String s = "abracadabra";

        String s = "aaabbaccccabba";

        solution(s);
    }

    public static int solution(String s) {
        int answer = 0;
        int start = 0;
        int size = s.length();

        while (start < size) {
            char chkChar = s.charAt(start);
            int sameCnt = 0;
            int diffCnt = 0;
            for (int i = start; i < size; i++) {
                char now = s.charAt(i);
                if (chkChar == now) {
                    sameCnt++;
                }
                if (chkChar != now) {
                    diffCnt++;
                }
                start++;
                if (sameCnt == diffCnt) {
                    break;
                }
            }
            answer++;
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}
