package test.kamobil;

public class Exam03 {
    public static void main(String[] args) {
//        int N = 2;
//        String S = "1A 2F 1C";
//        System.out.println(solution(N, S));

//        int N = 1;
//        String S = "";
//        System.out.println(solution(N, S));

        int N = 22;
        String S = "1A 3C 2B 20G 5A";
        System.out.println(solution(N, S));
    }
    public static int solution(int N, String S) {
        // Implement your solution here
        int answer = 0;
        boolean[][] airport = new boolean[N + 1][10];
        if (!S.equals("")) {
            String[] split = S.split(" ");
            for (int i = 0; i < split.length; i++) {
                String reservedSeat = split[i];

                int num = Character.isDigit(reservedSeat.charAt(0)) && Character.isDigit(reservedSeat.charAt(1)) ? Integer.parseInt(reservedSeat.charAt(0) + String.valueOf(reservedSeat.charAt(1))) : reservedSeat.charAt(0) - '0';
                int alpha = reservedSeat.charAt(reservedSeat.length() - 1) < 'I' ? reservedSeat.charAt(reservedSeat.length() - 1) : reservedSeat.charAt(reservedSeat.length() - 1) - 1;
                airport[num][alpha - 'A'] = true;
            }
        }
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j < airport[i].length; j++) {
//                System.out.print(airport[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i <= N; i++) {
            if (!airport[i][1] && !airport[i][2] && !airport[i][3] && !airport[i][4] && !airport[i][5] && !airport[i][6] && !airport[i][7] && !airport[i][8]) {
                answer += 2;
            } else if (!airport[i][1] && !airport[i][2] && !airport[i][3] && !airport[i][4]) {
                answer += 1;
            } else if (!airport[i][5] && !airport[i][6] && !airport[i][7] && !airport[i][8]) {
                answer += 1;
            } else if (!airport[i][3] && !airport[i][4] && !airport[i][5] && !airport[i][6]) {
                answer += 1;
            }
        }
        return answer;
    }

}
