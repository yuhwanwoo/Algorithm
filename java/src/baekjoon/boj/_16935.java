package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16935 {
    private static int n;
    private static int m;
    private static int r;
    private static int[][] inputArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        inputArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                inputArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int rotateNum = Integer.parseInt(st.nextToken());
            rotate(rotateNum);
        }

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[0].length; j++) {
                System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int rotateNum) {
        if (rotateNum == 1) {
            rotate1(inputArray);
        }
        if (rotateNum == 2) {
            rotate2(inputArray);
        }
        if (rotateNum == 3) {
            rotate3(inputArray);
        }
        if (rotateNum == 4) {
            rotate4(inputArray);
        }
        if (rotateNum == 5) {
            rotate5(inputArray);
        }
        if (rotateNum == 6) {
            rotate6(inputArray);
        }
    }

    private static void rotate1(int[][] prevArray) {
        int tmpNum;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                tmpNum = prevArray[i][j];
                prevArray[i][j] = prevArray[n - i - 1][j];
                prevArray[n - i - 1][j] = tmpNum;
            }
        }
    }

    private static void rotate2(int[][] prevArray) {
        int tmpNum;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                tmpNum = prevArray[i][j];
                prevArray[i][j] = prevArray[i][m - j - 1];
                prevArray[i][m - j - 1] = tmpNum;
            }
        }
    }

    private static void rotate3(int[][] prevArray) {
        int[][] tmpArray = new int[m][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpArray[j][n - 1 - i] = prevArray[i][j];
            }
        }

        int tempM = m;
        m = n;
        n = tempM;
        inputArray = tmpArray;
    }

    private static void rotate4(int[][] prevArray) {
        int[][] tmpArray = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpArray[m - 1 - j][i] = prevArray[i][j];
            }
        }

        int tempN = n;
        n = m;
        m = tempN;
        inputArray = tmpArray;
    }

    private static void rotate5(int[][] prevArray) {
        int[][] tmpArray1 = new int[n / 2][m / 2];
        int[][] tmpArray2 = new int[n / 2][m / 2];
        int[][] tmpArray3 = new int[n / 2][m / 2];
        int[][] tmpArray4 = new int[n / 2][m / 2];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                tmpArray1[i][j] = prevArray[i][j];
                tmpArray2[i][j] = prevArray[i][(m / 2) + j];
                tmpArray3[i][j] = prevArray[(n / 2) + i][j];
                tmpArray4[i][j] = prevArray[(n / 2) + i][(m / 2) + j];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                prevArray[i][j] = tmpArray3[i][j];
                prevArray[i][m / 2 + j] = tmpArray1[i][j];
                prevArray[n / 2 + i][j] = tmpArray4[i][j];
                prevArray[n / 2 + i][m / 2 + j] = tmpArray2[i][j];
            }
        }
        inputArray = prevArray;
    }

    private static void rotate6(int[][] prevArray) {
        int[][] tmpArray1 = new int[n / 2][m / 2];
        int[][] tmpArray2 = new int[n / 2][m / 2];
        int[][] tmpArray3 = new int[n / 2][m / 2];
        int[][] tmpArray4 = new int[n / 2][m / 2];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                tmpArray1[i][j] = prevArray[i][j];
                tmpArray2[i][j] = prevArray[i][(m / 2) + j];
                tmpArray3[i][j] = prevArray[(n / 2) + i][j];
                tmpArray4[i][j] = prevArray[(n / 2) + i][(m / 2) + j];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                prevArray[i][j] = tmpArray2[i][j];
                prevArray[i][m / 2 + j] = tmpArray4[i][j];
                prevArray[n / 2 + i][j] = tmpArray1[i][j];
                prevArray[n / 2 + i][m / 2 + j] = tmpArray3[i][j];
            }
        }
        inputArray = prevArray;
    }
}
