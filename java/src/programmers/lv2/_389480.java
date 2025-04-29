package programmers.lv2;

public class _389480 {
    private static int maxN;
    private static int maxM;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        solution(info, 4, 4);
    }

    public static int solution(int[][] info, int n, int m) {
        maxN = n;
        maxM = m;
        dfs(info, 0, 0, 0);
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }

    public static void dfs(int[][] info, int count, int sumN, int sumM) {
        if (sumN >= maxN || sumM >= maxM) {
            return;
        }
        if (count == info.length) {
            answer = Math.min(sumN, answer);
            return;
        }

        dfs(info, count + 1, sumN + info[count][0], sumM);
        dfs(info,count + 1, sumN, sumM + info[count][1]);
    }
}
