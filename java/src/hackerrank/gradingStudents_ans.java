package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class gradingStudents_ans {
    public static void main(String[] args) {

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> answer = new ArrayList<>(grades);

        for (int i = 0; i < grades.size(); i++) {
            int e = grades.get(i);
            System.out.println(e);

            if (e >= 38) {
                System.out.println("pass");

                if (e % 5 >= 3) {
                    int rounded = (e / 5 + 1) * 5;
                    answer.set(i, rounded);
                    System.out.println(rounded + " 반올림");
                } else {
                    System.out.println(e + " 반올림하지 않음");
                }

            } else {
                System.out.println("fail");
                answer.set(i, e);
                System.out.println(e + " fail은 반올림하지 않음");
            }
        }

        return answer;
    }
}
