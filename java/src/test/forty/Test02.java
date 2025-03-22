package test.forty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Test02 {
    private static HashMap<String, List<String>> map = new HashMap<>();
    private static HashMap<String, Boolean> visited = new HashMap<>();
    private static HashMap<String, Integer> relationMap = new HashMap<>();
    public static void main(String[] args) {
//        String [][] friends = {{"david","frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}};
//        String user_id = "david";

        String [][] friends = {{"david","demi"}, {"frank", "demi"}, {"demi", "james"}};
        String user_id = "frank";

        solution(friends, user_id);
    }

    public static String[] solution(String[][] friends, String user_id) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < friends.length; i++) {
            String from = friends[i][0];
            String to = friends[i][1];
            if (!relationMap.containsKey(from)) {
                relationMap.put(from, 0);
            }
            if (!relationMap.containsKey(to)) {
                relationMap.put(to, 0);
            }
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            if (!map.containsKey(to)) {
                map.put(to, new ArrayList<>());
            }
            if (!visited.containsKey(from)) {
                visited.put(from, false);
            }
            if (!visited.containsKey(to)) {
                visited.put(to, false);
            }
            map.get(from).add(to);
            map.get(to).add(from);
        }
        visited.put(user_id, true);
        dfs(user_id, 0);
        PriorityQueue<Pair> answerPriorityQueue = new PriorityQueue<>();
        for (String key : relationMap.keySet()) {
            answerPriorityQueue.add(new Pair(relationMap.get(key), key));
        }
        int size = answerPriorityQueue.size();
        int maxCount = answerPriorityQueue.peek().count;

        for (int i = 0; i < size; i++) {
            Pair top = answerPriorityQueue.peek();
            if (maxCount == top.count) {
                Pair poll = answerPriorityQueue.poll();
                answer.add(poll.name);
            }
        }
        return answer.toArray(new String[0]);
    }

    private static void dfs(String user_id, int depth) {
        if (depth == 2) {
            relationMap.put(user_id, relationMap.get(user_id) + 1);
            return;
        }

        for (int i = 0; i < map.get(user_id).size(); i++) {
            String nowUserId = map.get(user_id).get(i);
            if (!visited.get(nowUserId)) {
                visited.put(nowUserId, true);
                dfs(nowUserId, depth + 1);
                visited.put(nowUserId, false);
            }
        }
    }

    private static class Pair implements Comparable<Pair> {
        int count;
        String name;

        public Pair(int count, String name) {
            this.count = count;
            this.name = name;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.count == this.count) {
                return this.name.compareTo(o.name);
            }
            return o.count - this.count;
        }
    }
}
