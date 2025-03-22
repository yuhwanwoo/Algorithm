package programmers.lv2;

public class _87946_ans {
    static boolean[] visited;
    static int answer = -1;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        DFS(k, dungeons, 0);
        return answer;
    }

    public void DFS(int k, int[][] dungeons, int cnt){

        answer = Math.max(answer, cnt);
        for(int i=0; i<dungeons.length; i++){
            if(visited[i] == false && dungeons[i][0] <= k){
                // 최소 필요 피로도가 현재 피로도보다 작을 때

                visited[i] = true;
                k -= dungeons[i][1];

                DFS(k, dungeons, cnt+1);

                visited[i] = false;
                k += dungeons[i][1];

            }
        }

    }
}
