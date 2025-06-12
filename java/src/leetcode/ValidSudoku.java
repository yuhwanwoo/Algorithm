package leetcode;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean validSudoku = isValidSudoku(board);
        System.out.println("validSudoku = " + validSudoku);

        char[][] input = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean validSudoku2 = isValidSudoku(input);
        System.out.println("validSudoku2 = " + validSudoku2);
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rowSets = new HashSet[9];
        HashSet<Integer>[] colSets = new HashSet[9];
        HashSet<Integer>[][] boxSets = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {//HashSet 초기화
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i / 3][i % 3] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int current = board[i][j];
                if (current != '.') {
                    if (rowSets[i].contains(current) || colSets[j].contains(current) || boxSets[i / 3][j / 3].contains(current)) {
                        return false;
                    }
                    rowSets[i].add(current);
                    colSets[j].add(current);
                    boxSets[i / 3][j / 3].add(current);
                }
            }
        }

        return true;
    }
}
