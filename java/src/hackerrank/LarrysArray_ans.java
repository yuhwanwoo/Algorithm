package hackerrank;

import java.util.List;

/*
역전 개수로 구하는 문제
 */
public class LarrysArray_ans {
    public static void main(String[] args) {
        larrysArray(List.of(1, 6, 5, 2, 4, 3));
    }

    public static String larrysArray(List<Integer> A) {
        // Write your code here
        boolean flag = true;
        int length = A.size();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (A.get(i) > A.get(j)) {
                    flag = !flag;
                }
            }
        }
        return flag ? "YES" : "NO";
    }


}
