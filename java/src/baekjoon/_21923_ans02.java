package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21923_ans02 {
    static int N , M;
    static int max;
    static int [][] score;
    static int [][] upMove, dwMove ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ") ;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = -999999999;
        score = new int[N][M];
        upMove = new int[N][M];
        dwMove = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ") ;
            for (int j = 0; j < M; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        //올라가는 방향
        upMove[N-1][0] = score[N-1][0];
        for (int i = N-1; i >= 0; i--) {

            if(i!=N-1) upMove[i][0] = upMove[i+1][0] + score[i][0];
            for (int j = 1; j < M; j++) {
                if(i!=N-1) upMove[i][j] = Math.max(upMove[i+1][j], upMove[i][j-1])+ score[i][j];
                else upMove[i][j] =  upMove[i][j-1] + score[i][j];
            }
        }

        //내려가는 방향
        dwMove[N-1][M-1] = score[N-1][M-1];
        for (int i = N-1; i >= 0; i--) {
            if(i!=N-1) dwMove[i][M-1] = dwMove[i+1][M-1] + score[i][M-1];
            for (int j = M-2; j >=0; j--) {
                if(i!=N-1) dwMove[i][j] = Math.max(dwMove[i+1][j], dwMove[i][j+1])+ score[i][j];
                else dwMove[i][j] = dwMove[i][j+1] + score[i][j];

            }
        }

        //올라가는 점수 + 내려가는점수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(dwMove[i][j]+ upMove[i][j] , max);
            }
        }

        System.out.println(max);
    }
}
