package programmers.year2023.lv1;

public class _17681 {
    public static void main(String[] args) {
//        int n = 5;
//        int[] arr1 = {9,20,28,18,11};
//        int[] arr2 = {30,1,21,17,28};

        int n = 6;
        int[] arr1 = {46,33,33,22,31,50};
        int[] arr2 = {27,56,19,14,14,10};
        solution(n, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[][] strArray1 = new String[n][n];
        String[][] strArray2 = new String[n][n];

        for (int i = 0; i < n; i++) {
            String input = Integer.toBinaryString(arr1[i]);
            System.out.println("input = " + input);
            System.out.println("arr[i] = " + arr1[i]);
            input = "0".repeat(n - input.length()) + input;
            strArray1[i] = input.split("", -1);

            input = Integer.toBinaryString(arr2[i]);
            input = "0".repeat(n - input.length()) + input;
            strArray2[i] = input.split("", -1);
        }

        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < n; j++) {
                if (strArray1[i][j].equals("0") && strArray2[i][j].equals("0")) {
                    tmp += " ";
                } else {
                    tmp += "#";
                }
            }
            answer[i] = tmp;
            System.out.println("tmp = " + tmp);
        }
        return answer;
    }
}
