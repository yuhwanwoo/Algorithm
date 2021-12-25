package test.ztest;

public class test03 {
    public static void main(String[] args) {
//        int[] histogram = {2,2,2,4};
        int[] histogram = {6,5,7,3,4,2};

        solution(histogram);
    }

    private static int solution(int[] histogram) {
        int size = histogram.length;

        int answer = 0;
        int start = 0;
        int end = 1;

        while (true) {
            if (end == size) {
                start += 1;
                end = start + 1;
            }

            if (start == size - 2) {
                break;
            }

            if (start < end) {
                if (histogram[start] < histogram[end]) {
                    answer = Math.max(answer, (end - start - 1) * histogram[start]);
                } else {
                    answer = Math.max(answer, (end - start - 1) * histogram[end]);
                }
                end += 1;
            }

        }
        return answer;
    }
}
