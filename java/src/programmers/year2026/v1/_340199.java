package programmers.year2026.v1;

public class _340199 {
    static void main() {
        int[] wallet = {30,15};
        int[] bill = {26,17};
        solution(wallet, bill);

        int[] wallet1 = {50,50};
        int[] bill1 = {100, 241};
        solution(wallet1, bill1);
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int billX = bill[0];
        int billY = bill[1];
        while ((billX > wallet[0] || billY > wallet[1]) && (billX > wallet[1] || (billY > wallet[0]))
        ) {
            answer++;
            if (billX <= billY) {
                billY /= 2;
            } else {
                billX /= 2;
            }
        }
        return answer;
    }
}
