package etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Failed {

    private static String[] solution(String[] members) {
        int p = 123;

        List<String> order = new ArrayList<>();
        HashMap<String, String> recommenders = new HashMap<>();
        HashMap<String, Integer> idx = new HashMap<>();
        HashMap<String, Integer> points = new HashMap<>();

        for (int i = 0; i < members.length; i++) {
            String[] info = members[i].split(" ");
            String name = info[0];
            String recommender = info[1];
            recommenders.put(name, recommender);
            idx.put(name, i);
            order.add(name);
            points.put(name, 0);
        }

        for (String member : order) {
            String recommender = recommenders.get(member);
            if (recommender.equals("-")) {
                continue;
            }
            int gain = p;
            points.put(recommender, points.get(recommender) + gain);
        }
        return null;
    }
}
