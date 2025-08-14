package hackerrank;

import java.util.List;

public class BetweenTwoSets_ans {
    public static void main(String[] args) {
        getTotalX(List.of(2, 6), List.of(24, 36));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int cnt = 0;
        int lcm_elem = a.get(0);
        for (Integer elem_a : a) {
            lcm_elem = lcm(lcm_elem, elem_a);
        }

        int gcd_elem = b.get(0);
        for (Integer elem_b : b) {
            gcd_elem = gcd(gcd_elem, elem_b);
        }

        int elem_c = 0;
        while (elem_c <= gcd_elem) {
            elem_c += lcm_elem;

            if (gcd_elem % elem_c == 0) {
                cnt++;
            }
        }
        return cnt;

    }

    public static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n1, n1 % n2);
    }

    public static int lcm(int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        } else {
            int gcd = gcd(n1, n2);
            return Math.abs(n1 * n2) / gcd;
        }
    }
}
