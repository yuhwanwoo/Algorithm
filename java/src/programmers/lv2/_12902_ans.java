package programmers.lv2;

public class _12902_ans {

    long[] tile = new long[5001];

    public long solution(int n) {
        long answer = 0;
        int mod=1000000007;

        tile[0]=1;
        tile[2]=3;

        for(int i=4; i<=n; i+=2){
            tile[i] = tile[i-2] * 3;
            for(int j=i-4; j>=0; j-=2){
                tile[i] += tile[j] * 2;
            }
            tile[i] = tile[i] % mod;
        };

        return answer=tile[n];
    }
}
