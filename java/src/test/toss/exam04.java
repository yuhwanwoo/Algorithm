package test.toss;

import java.util.ArrayList;
import java.util.HashMap;

public class exam04 {
    public static void main(String[] args) {

        long[][] invitationsPairs = {{1,2}, {2,3}, {2,4}, {2,5}, {5,6},{5,7},{6,8},{2,9}};


//        System.out.println("solution(invitationsPairs) = " + solution(invitationsPairs));
    }

//    private static long[] solution(long[][] invitationPairs) {
//        HashMap<Long, ArrayList<Long>> map = new HashMap<>();
//
//        for (int i = 0; i < invitationPairs.length; i++) {
//            long key = invitationPairs[i][0];
//            long value = invitationPairs[i][1];
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//                map.get(key).add(value);
//            }
//            map.get(key).add(value);
//        }
//
//        for (Long key : map.keySet()) {
//            int tmpSum = map.get(key).size() * 10;
//            tmpSum += getPoint(key, map);
//        }
//        return null;
//    }
//
//    private static int getPoint(Long key, HashMap<Long, ArrayList<Long>> map) {
//        for (int i = 0; i < map.get(key).size(); i++) {
//            for (int j = 0; j < map.get(map.get(key).get(i)).size(); j ++) {
//
//            }
//
//        }
//
//    }
}
