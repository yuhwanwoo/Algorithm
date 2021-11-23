package test;

public class del01 {
    static int r ;
    static int c ;
    static String[][] arr;

    public static void main(String[] args) {
        String[] B = {".##.#", "#.#..", "#...#", "#.##."};

        solution(B);
    }

    public static int[] solution(String[] B) {
        int[] answer = {0, 0, 0};
        r = B.length;
        c = B[0].length();

        arr = new String[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char[] tmp = B[i].toCharArray();

                arr[i][j] = Character.toString(tmp[j]);
//                System.out.print(arr[i][j]);
            }
//            System.out.println();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j].equals("#")) {
//                    System.out.println(dfs(i, j, 1));
                    int result = dfs(i, j, 1);
                    if(result == 1) {
                        answer[0] += 1;
                    } else if(result == 2) {
                        answer[1] += 1;
                    } else{
                        answer[2] += 1;
                    }
                }
            }
        }
        return answer;

    }

    public static int dfs(int x, int y, int size) {
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return 0;
        }
        if (arr[x][y].equals("#")) {
            arr[x][y] = ".";

            size += dfs(x - 1, y, size);
            size += dfs(x, y - 1, size);
            size += dfs(x + 1, y, size);
            size += dfs(x, y + 1, size);

            return size;
        }

        return 0;
    }
}
