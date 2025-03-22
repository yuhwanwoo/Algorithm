package programmers.year2023.lv1;

public class _42862 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1, 3, 5};

        solution(n, lost, reserve);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] chkCloth = new int[n];

        /*
        -1 이 도난 당한 것
        0이 1개 가진 것
        1이 여벌이 있는 것
         */
        for (int i = 0; i < lost.length; i++) {
            chkCloth[lost[i] - 1]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            chkCloth[reserve[i] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (chkCloth[i] == 1 && chkCloth[i + 1] == -1) {
                    chkCloth[i] = 0;
                    chkCloth[i + 1] = 0;
                }
            } else if (i == n - 1) {
                if (chkCloth[i] == 1 && chkCloth[i - 1] == -1) {
                    chkCloth[i] = 0;
                    chkCloth[i - 1] = 0;
                }
            } else {
                if (chkCloth[i] == 1 && chkCloth[i - 1] == -1) {
                    chkCloth[i] = 0;
                    chkCloth[i - 1] = 0;
                    continue;
                }
                if (chkCloth[i] == 1 && chkCloth[i + 1] == -1) {
                    chkCloth[i] = 0;
                    chkCloth[i + 1] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (chkCloth[i] == 0 || chkCloth[i] == 1) {
                answer++;
            }
        }
        return answer;
    }
}
