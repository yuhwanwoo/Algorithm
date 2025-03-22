package test.ig;

public class Test02 {
    // https://gist.github.com/pupattan/3d081415e00bfc5318ac85c1faff775a
    public static void main(String[] args) {
//        String S = "-H-HH--";
        String S =  "H--H-H-";

        System.out.println(solution(S));
    }

    private static int solution(String S) {
        int answer = 0;
        int length = S.length();

        boolean isPrev;
        boolean isNext;

        for (int i = 0; i < S.length(); i++) {
            isNext = false;
            isPrev = false;
            char now = S.charAt(i);
            if (now == 'H') {
                System.out.println("answer = " + answer +", i = " + i);
                if (i != 0 && S.charAt(i - 1) == '-') {
                    isPrev = true;
                }

                if (i != S.length() - 1 && S.charAt(i + 1) == '-') {
                    isNext = true;
                }

                if (!isNext && !isPrev) {
                    return -1;
                }

                if (isNext && (i - 1 != length || !isPrev)) {
                    answer++;
                    length = i + 1;
                }
                if (isPrev && !isNext && length != (i - 1)) {
                    answer++;
                    length = i - 1;
                }
            }

        }
        System.out.println("-----------------------------");
        System.out.println("answer = " + answer);


        return answer;
    }
}
