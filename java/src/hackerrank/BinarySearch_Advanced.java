package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch_Advanced {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        int firstOccurence = findFirstOccurence(arr, target);
        int lastOccurence = findLastOccurence(arr, target);

        System.out.println("firstOccurence = " + firstOccurence);
    }

    private static int findFirstOccurence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                end = mid - 1;
                result = mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private static int findLastOccurence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (arr[mid] == target) {
//                end = mid + 1;
//                result = mid;
//            } else if (arr[mid] < target) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
        return result;
    }
}
