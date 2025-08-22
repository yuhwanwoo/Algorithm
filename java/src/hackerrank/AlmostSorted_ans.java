package hackerrank;

import java.util.List;

public class AlmostSorted_ans {
    public static void main(String[] args) {

    }

    public static void almostSorted(List<Integer> arr) {
        // Write your code here
        int n = arr.size();

        // 1) 이미 정렬?
        if (isSorted(arr)) {
            System.out.println("yes");
            return;
        }

        // 2) 첫 감소 지점 l, 마지막 감소 지점 r 찾기
        int l = -1, r = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                if (l == -1) l = i;
                r = i; // 마지막 감소 지점으로 갱신
            }
        }

        int i1 = l;
        int j1 = r + 1; // 경계의 반대쪽

        // 3) swap 시도
        swap(arr, i1, j1);
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("swap " + (i1 + 1) + " " + (j1 + 1));
            return;
        }
        // 복구
        swap(arr, i1, j1);

        // 4) reverse 시도
        reverse(arr, i1, j1);
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("reverse " + (i1 + 1) + " " + (j1 + 1));
            return;
        }

        // 5) 둘 다 안되면 no
        System.out.println("no");
    }

    private static boolean isSorted(List<Integer> a) {
        for (int i = 0; i + 1 < a.size(); i++) {
            if (a.get(i) > a.get(i + 1)) return false;
        }
        return true;
    }

    private static void swap(List<Integer> a, int i, int j) {
        Integer tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    private static void reverse(List<Integer> a, int l, int r) {
        while (l < r) {
            swap(a, l, r);
            l++;
            r--;
        }
    }


}
