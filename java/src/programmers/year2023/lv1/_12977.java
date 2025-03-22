package programmers.year2023.lv1;

public class _12977 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {1, 2, 7, 6, 4};
        solution(nums);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int size = nums.length;
        int firstIdx = 0;
        int secondIdx = 1;
        int thirdIdx = 2;

        while (true) {
            if (firstIdx == size - 2) {
                break;
            }

            if (secondIdx == size - 1) {
                firstIdx++;
                secondIdx = firstIdx + 1;
                thirdIdx = firstIdx + 2;
                continue;
            }


            if (thirdIdx == size) {
                secondIdx++;
                thirdIdx = secondIdx + 1;
                continue;
            }

            int sum = nums[firstIdx] + nums[secondIdx] + nums[thirdIdx];
            if (isPrime(sum)) {
                answer++;
            }


            thirdIdx++;

            // ***11 **1*1 **11* *1**1 *1*1* *11** 11111 11111
        }

        return answer;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
