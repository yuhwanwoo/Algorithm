package programmers.lv1;

public class _86491 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println("solution(sizes) = " + solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int col = 0;
        int row = 0;
        for (int[] size : sizes) {
            if (size[0] >= size[1]) {
                col = Math.max(col, size[0]);
                row = Math.max(row, size[1]);
            } else {
                col = Math.max(col, size[1]);
                row = Math.max(row, size[0]);
            }
        }

        return col * row;
    }
}
