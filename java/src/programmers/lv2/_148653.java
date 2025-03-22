package programmers.lv2;

public class _148653 {
    public static void main(String[] args) {
        solution(16); // 6
        solution(2554); //16
//        solution(1);
//        solution(9);
//        solution(555);
        solution(95); // 6
        solution(45); //9
        solution(678); // 8
        solution(999); //2
        solution(155); //11
        solution(154); //10
        solution(545); //14
//        solution(5555);
//        solution(55);
//        solution(5);
//        solution(56); // 9
    }

    public static int solution(int storey) {
        int answer = 0;
        int mod;
        while (storey != 0) {
            if (storey % 10 > 5) {
                answer += (10 - (storey % 10));
                mod = 1;
            } else if (storey % 10 == 5) {
                answer += 5;
                mod = 0;
                if (storey > 10) {
                    if (storey / 10 % 10 >= 5) {
                        storey += 10;
                    }
                }
            } else {
                answer += (storey % 10);
                mod = 0;
            }
            storey /= 10;
            storey += mod;
        }

        return answer;
    }
}
