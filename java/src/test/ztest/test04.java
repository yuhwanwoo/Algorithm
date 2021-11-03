package test.ztest;

public class test04 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1,3,5,1}, {1,1,3,3,5,5}, {8,3,3,3,1,5},{3,3,3,4,4,4},{3,3,4,4,4,4},{1,4,4,4,4,4}};

        solution(grid);
    }

    private static int[] solution(int[][] grid) {
        int[] answer = new int[2];
        int size = grid.length;

        for (int i = 1; i < size + 1; i++) {
            int[][] arr = mkArr(i);
            for (int j = 0; j < 4; j++){
                int[][] now = rotArr(arr);
                int row = now.length;
                int col = now[0].length;
                for (int n = 0; n < size - row; n++) {
                    for (int m = 0; m < size - col; m++) {

                    }
                }
            }

        }
        return answer;
    }

    private static int[][] rotArr(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n-1-j][i];
            }
        }
        return rotate;
    }

    private static int[][] mkArr(int n) {
        int row = n;
        int col = 2 * n - 1;
        int[][] arr = new int[n][col];
        for (int i = 0; i < row; i++){
            for (int j = i; j < i + n; j ++) {
                arr[i][j] = 1;
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        return arr;

    }
}
