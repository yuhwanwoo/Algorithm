package test.toss;

public class exam03 {
    private static boolean visited[];
    private static int answer = 0;
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

//        int k = 966;
//        int[][] dungeons = {{700,266},{111,78},{871,655}};

        System.out.println("answer: " + solution(k, dungeons));
    }

    private static int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        dfs(k, 0, 0, dungeons);
        return answer;
    }

    private static void dfs(int nowHeath,int depth, int index, int[][] dungeons) {
        if ((nowHeath < 0 || dungeons[index][0] < nowHeath) && depth != 0) {
            System.out.println("depth = " + depth);
            System.out.println("nowHeath = " + nowHeath);
            System.out.println("index = " + index);
            answer = Math.max(answer, depth - 1);
        } else {
            System.out.println("depth1 = " + depth);
            System.out.println("nowHeath1 = " + nowHeath);
            System.out.println("index1 = " + index);
            answer = Math.max(answer, depth);
        }
        if (nowHeath < 0) {
            return;
        }


        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(nowHeath - dungeons[i][1], depth + 1, i, dungeons);
                visited[i] = false;
            }
        }
    }
}
