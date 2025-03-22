package programmers.year2023.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class _150370 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        solution(today, terms, privacies);

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();

        String[] todaySplit = today.split("\\.");
        int year = Integer.parseInt(todaySplit[0]);
        int month = Integer.parseInt(todaySplit[1]);
        int day = Integer.parseInt(todaySplit[2]);
        int totalLength = ((year * 12) + month) * 28 + day;

        for (String term : terms) {
            String[] strings = term.split(" ");
            String kind = strings[0];
            int termMonth = Integer.parseInt(strings[1]);
            map.put(kind, termMonth);
        }

        ArrayList<Integer> answerArray = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] strings = privacy.split(" ");
            String input = strings[0];
            String[] date = input.split("\\.");
            int dateYear = Integer.parseInt(date[0]);
            int dateMonth = Integer.parseInt(date[1]);
            int dateDay = Integer.parseInt(date[2]);
            Integer term = map.get(strings[1]);
            int privacyMonth = (dateMonth + term) % 12;
            int privacyYear = dateYear + ((dateMonth + term) / 12);
            if (totalLength >= ((privacyYear * 12) + privacyMonth) * 28 + dateDay) {
                answerArray.add(i + 1);
            }
        }
        Collections.sort(answerArray);
        return Arrays.stream(answerArray.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }
}
