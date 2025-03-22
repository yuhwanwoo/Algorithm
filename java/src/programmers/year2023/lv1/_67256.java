package programmers.year2023.lv1;

public class _67256 {
    static String leftHand = "*";
    static String rightHand = "#";

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        solution(numbers, hand);
    }
    /*
    L : * , R : #
    L : 1 , R : #
    L : 1 , R : 3
    L : 4 , R : 3
    L : 5 , R : 3
     */

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer += "L";
                leftHand = String.valueOf(number);
            }
            if (number == 3 || number == 6 || number == 9) {
                answer += "R";
                rightHand = String.valueOf(number);
            }
            if (number == 2 || number == 5 || number == 8 || number == 0) {
                if (getLeftHandDistance(number) > getRightHandDistance(number)) {
                    answer += "R";
                    rightHand = String.valueOf(number);
                } else if (getLeftHandDistance(number) < getRightHandDistance(number)) {
                    answer += "L";
                    leftHand = String.valueOf(number);
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        rightHand = String.valueOf(number);
                    } else {
                        answer += "L";
                        leftHand = String.valueOf(number);
                    }
                }
            }

        }
        return answer;
    }

    private static int getLeftHandDistance(int number) {
        if ((leftHand.equals(String.valueOf(2)) && number == 2) ||
                (leftHand.equals(String.valueOf(5)) && number == 5) ||
                (leftHand.equals(String.valueOf(8)) && number == 8) ||
                (leftHand.equals(String.valueOf(0)) && number == 0)
        ) {
            return 0;
        }
        if ((leftHand.equals(String.valueOf(1)) && number == 2) ||
                (leftHand.equals(String.valueOf(4)) && number == 5) ||
                (leftHand.equals(String.valueOf(7)) && number == 8) ||
                (leftHand.equals("*") && number == 0) ||
                (leftHand.equals(String.valueOf(2)) && number == 5) ||
                (leftHand.equals(String.valueOf(5)) && number == 2) ||
                (leftHand.equals(String.valueOf(5)) && number == 8) ||
                (leftHand.equals(String.valueOf(8)) && number == 5) ||
                (leftHand.equals(String.valueOf(8)) && number == 0) ||
                (leftHand.equals(String.valueOf(0)) && number == 8)
        ) {
            return 1;
        }
        if ((leftHand.equals(String.valueOf(1)) && number == 5) ||
                (leftHand.equals(String.valueOf(4)) && number == 2) ||
                (leftHand.equals(String.valueOf(4)) && number == 8) ||
                (leftHand.equals(String.valueOf(7)) && number == 5) ||
                (leftHand.equals(String.valueOf(7)) && number == 0) ||
                (leftHand.equals("*") && number == 8) ||
                (leftHand.equals(String.valueOf(2)) && number == 8) ||
                (leftHand.equals(String.valueOf(5)) && number == 0) ||
                (leftHand.equals(String.valueOf(8)) && number == 2) ||
                (leftHand.equals(String.valueOf(0)) && number == 5)
        ) {
            return 2;
        }

        if ((leftHand.equals(String.valueOf(1)) && number == 8) ||
                (leftHand.equals(String.valueOf(4)) && number == 0) ||
                (leftHand.equals(String.valueOf(7)) && number == 2) ||
                (leftHand.equals(String.valueOf(2)) && number == 0) ||
                (leftHand.equals(String.valueOf(0)) && number == 2)
        ) {
            return 3;
        }

        if ((leftHand.equals(String.valueOf(1)) && number == 0) ||
                (leftHand.equals("*") && number == 2)
        ) {
            return 4;
        }
        return 5;
    }

    private static int getRightHandDistance(int number) {
        if ((rightHand.equals(String.valueOf(2)) && number == 2) ||
                (rightHand.equals(String.valueOf(5)) && number == 5) ||
                (rightHand.equals(String.valueOf(8)) && number == 8) ||
                (rightHand.equals(String.valueOf(0)) && number == 0)
        ) {
            return 0;
        }
        if ((rightHand.equals(String.valueOf(3)) && number == 2) ||
                (rightHand.equals(String.valueOf(6)) && number == 5) ||
                (rightHand.equals(String.valueOf(9)) && number == 8) ||
                (rightHand.equals("#") && number == 0) ||
                (rightHand.equals(String.valueOf(2)) && number == 5) ||
                (rightHand.equals(String.valueOf(5)) && number == 2) ||
                (rightHand.equals(String.valueOf(5)) && number == 8) ||
                (rightHand.equals(String.valueOf(8)) && number == 5) ||
                (rightHand.equals(String.valueOf(8)) && number == 0) ||
                (rightHand.equals(String.valueOf(0)) && number == 8)
        ) {
            return 1;
        }
        if ((rightHand.equals(String.valueOf(3)) && number == 5) ||
                (rightHand.equals(String.valueOf(6)) && number == 2) ||
                (rightHand.equals(String.valueOf(6)) && number == 8) ||
                (rightHand.equals(String.valueOf(9)) && number == 5) ||
                (rightHand.equals(String.valueOf(9)) && number == 0) ||
                (rightHand.equals("#") && number == 8) ||
                (rightHand.equals(String.valueOf(2)) && number == 8) ||
                (rightHand.equals(String.valueOf(5)) && number == 0) ||
                (rightHand.equals(String.valueOf(8)) && number == 2) ||
                (rightHand.equals(String.valueOf(0)) && number == 5)
        ) {
            return 2;
        }

        if ((rightHand.equals(String.valueOf(3)) && number == 8) ||
                (rightHand.equals(String.valueOf(6)) && number == 0) ||
                (rightHand.equals(String.valueOf(9)) && number == 2) ||
                (rightHand.equals(String.valueOf(2)) && number == 0) ||
                (rightHand.equals(String.valueOf(0)) && number == 2)
        ) {
            return 3;
        }

        if ((rightHand.equals(String.valueOf(3)) && number == 0) ||
                (rightHand.equals("#") && number == 2)
        ) {
            return 4;
        }
        return 5;
    }
}
