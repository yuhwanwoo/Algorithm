package hackerrank;

public class CountingValleys_ans {
    public static void main(String[] args) {

    }

    static int countingValleys(int n, String s) {
        int cnt = 0;
        int sum = 0;
        for(int i =0; i < n; i++){
            char step = s.charAt(i);
            if(step == 'U'){
                if(sum == - 1){
                    sum++;
                    cnt++;
                }else{
                    sum++;
                }
            }else{
                sum --;
            }
        }
        return cnt;
    }
}
