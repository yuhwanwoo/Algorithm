package leetcode;

public class _FirstBadVersion {
    public int firstBadVersion(int n) {
        int s = 1;
        int e = n;

        while (s < e) {
            int mid = s + (e - s) / 2;

            if(isBadVersion(mid)) {
                e = mid;
            }else {
                s = mid + 1;
            }
        }

        System.out.println(s);
        return s;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
