package programmers.year2023.lv1;

public class _86491 {
    public static void main(String[] args) {
//        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        int[][] sizes = {{10,7}, {12,3}, {8,15}, {14,7}, {5,15}};

        solution(sizes);
    }

    public static int solution(int[][] sizes) {
        int maxInMin = 0;
        int maxInMax = 0;
        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];
            if (size[0] > size[1]) {
                maxInMin = Math.max(maxInMin, size[1]);
                maxInMax = Math.max((maxInMax), size[0]);
            } else {
                maxInMin = Math.max(maxInMin, size[0]);
                maxInMax = Math.max((maxInMax), size[1]);
            }
        }
        return maxInMax * maxInMin;
    }
}
