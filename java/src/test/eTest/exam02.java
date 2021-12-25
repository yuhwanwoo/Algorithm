package test.eTest;

import java.util.ArrayList;

public class exam02 {

    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) {
//        int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1,1,0}, {1,0,1}, {1,1,0} ,{0,1,1}};
//        int r = 2;


        int[][] needs = {{1,1,1}, { 1,0,1},{1,1,1}};
        int r = 3;



        System.out.println(solution(needs, r));
    }

    public static int solution(int[][] needs, int r) {
        int answer = 0;
        int size = needs[0].length;
        int case_len = needs.length;

        arr = new ArrayList<>();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        Combination(array, 0, size, r, 0, new int[size]);

        for (int i = 0 ; i <arr.size(); i++) {

            // 조합 결과(인덱스) 하나씩 체크
            ArrayList<Integer> now = arr.get(i);

            int cnt = 0;

            int[] visited = new int[size];

            // 조합 결과 방문 체크
            for(int j = 0; j < r; j++) {
                visited[now.get(j)] = 1;
            }

            for(int j = 0; j < case_len; j++) {
                boolean flag = false;
                for(int t = 0; t < size; t++) {
                   if (visited[t] == 0 && needs[j][t] == 1){
                       flag = true;
                   }
                }

                if (!flag) {
                    cnt += 1;
                }
            }

            answer = Math.max(answer, cnt);

        }

        return answer;
    }

    public static void Combination(int[] array, int index, int n, int k, int t, int[] newcomb) {
        if(k == 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0; i<newcomb.length; i++){
                tmp.add(newcomb[i]);
            }
            arr.add(tmp);
            return;
        }
        if(t == n) return;
        newcomb[index] = array[t];
        Combination(array,index+1, n, k-1,t+1, newcomb); //선택했을 때
        Combination(array,index, n, k, t+1, newcomb); //선택 안했을 때
    }

}
