package leetcode;

import java.util.PriorityQueue;

public class _findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = 0;

        for(int i = 0; i < nums1.length; i++) {
            pq.add(nums1[i]);
            size += 1;
        }

        for(int i = 0; i < nums2.length; i++) {
            pq.add(nums2[i]);
            size += 1;
        }

        int cnt = 0;

        if(size % 2 == 0) {
            double ans = 0;
            for(int i = 0; i < size; i++) {
                double now = (double) pq.poll();
                if((i == (size/2)) || (i == ((size/2) - 1)))
                {
                    ans += now;
                }
            }
            System.out.println(ans);
            return (double) (ans / 2) ;

        } else {
            for(int i = 0; i < size; i++) {
                double now = (double) pq.poll();
                if(i == (size / 2)) {
                    return now;
                }
            }

        }

        return 0;
    }
}
