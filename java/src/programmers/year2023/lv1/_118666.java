package programmers.year2023.lv1;

import java.util.HashMap;

public class _118666 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5,3,2,7,5};
        solution(survey, choices);
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> surveyScore = new HashMap<>();

        surveyScore.put("R", 0);
        surveyScore.put("T", 0);
        surveyScore.put("C", 0);
        surveyScore.put("F", 0);
        surveyScore.put("J", 0);
        surveyScore.put("M", 0);
        surveyScore.put("A", 0);
        surveyScore.put("N", 0);

        for (int i = 0; i < survey.length; i++) {
            String[] split = survey[i].split("");
            String first = split[0];
            String second = split[1];
            int choice = choices[i];
            if (choice < 4) {
                surveyScore.put(first, surveyScore.get(first) + (4 - choice));
            } else if (choice > 4) {
                surveyScore.put(second, surveyScore.get(second) + (choice - 4));
            }
        }
        if (surveyScore.get("R") >= surveyScore.get("T")) {
            answer += "R";
        } else {
            answer += "T";
        }
        if (surveyScore.get("C") >= surveyScore.get("F")) {
            answer += "C";
        } else {
            answer += "F";
        }
        if (surveyScore.get("J") >= surveyScore.get("M")) {
            answer += "J";
        } else {
            answer += "M";
        }
        if (surveyScore.get("A") >= surveyScore.get("N")) {
            answer += "A";
        } else {
            answer += "N";
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
