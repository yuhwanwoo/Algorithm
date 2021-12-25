package leetcode;

public class Sqrt_x {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long s = 1;
        long e = x;

        while(s < e) {
            long mid = (long)(s + e) / 2;
            System.out.println(mid);
            if (mid * mid <= x && x < ((mid + 1) * (mid + 1))) {

                return (int)mid;
            } else if ((mid * mid) > x) {
                e = mid;
            }else {
                s = mid + 1;
            }
        }

        return 0;
    }
}
