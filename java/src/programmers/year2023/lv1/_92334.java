package programmers.year2023.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _92334 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        solution(id_list, report, k);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        HashMap<String, Integer> idxByString = new HashMap<>();
        HashMap<String, HashSet<String>> reportedId = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            idxByString.put(id, i);
        }
        for (String detail : reportSet) {
            String[] split = detail.split(" ");
            String from = split[0];
            String to = split[1];
            if (!reportedId.containsKey(to)) {
                reportedId.put(to, new HashSet<>());
            }
            reportedId.get(to).add(from);
        }
        for (String key : reportedId.keySet()) {
            if (reportedId.get(key).size() >= k) {
                for (String name : reportedId.get(key)) {
                    answer[idxByString.get(name)] += 1;
                }
            }
        }

        return answer;
    }
}
