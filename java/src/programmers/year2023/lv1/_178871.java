package programmers.year2023.lv1;

import java.util.HashMap;

public class _178871 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        solution(players, callings);
    }

    public static String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            String player = players[i];
            map.put(player, i);
        }

        for (String calling : callings) {
            int calledIdx = map.get(calling);
            String tmp = players[calledIdx - 1];
            players[calledIdx - 1] = calling;
            players[calledIdx] = tmp;
            map.put(calling, calledIdx - 1);
            map.put(tmp, calledIdx);
        }

        return players;
    }
}
