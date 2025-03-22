package test.kream;

public class Exam02 {
    public static void main(String[] args) {
//        findRange(111);
        System.out.println("findRange(999999) = " + findRange(80));
    }

    public static long findRange(int num) {
        int maxTarget = -1;
        int minTarget = -1;
        int maxValue = 0;
        int minValue = 0;
        int initLength = (int) Math.log10(num);
        int length = (int) Math.log10(num);
        boolean firstFlag = false;

        while (num != 0) {
            int now = num / (int) Math.pow(10, length);


            if (maxTarget == -1 && now != 9) {
                maxTarget = now;
            }

            if (maxTarget != -1 && (num / (int) Math.pow(10, length)) == maxTarget) {
                maxValue += (Math.pow(10, length) * 9);
            } else {
                maxValue += (Math.pow(10, length) * now);
            }

            if (initLength == length && now != 1 && minTarget == -1) {
                minTarget = now;
                firstFlag = true;
            } else if (minTarget == -1 && initLength != length && now != 0 && now != 1) {
                minTarget = now;
            }

            if (minTarget != -1 && (num / (int) Math.pow(10, length)) == minTarget && firstFlag) {
                minValue += (Math.pow(10, length) * 1);
            } else if (minTarget != -1 && (num / (int) Math.pow(10, length)) == minTarget && !firstFlag) {
                minValue += (Math.pow(10, length) * 0);
            } else {
                minValue += (Math.pow(10, length) * now);
            }

            num %= Math.pow(10, length);
            length -= 1;
        }

        return maxValue - minValue;
    }
}
