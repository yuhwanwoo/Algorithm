package algo;

public class LowerAndUpperBound {
    public static void main(String[] args) {
        // https://velog.io/@junhok82/lowerbound-upperbound
    }

    private static int lowerBound(int[] arr, int target) {
        int begin = 0;
        int end = arr.length;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (arr[mid] >= target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }

    private static int upperBound(int[] arr, int target) {
        int begin = 0;
        int end = arr.length;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (arr[mid] <= target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
