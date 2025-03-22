package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;

public class _258712_ans {
    public int solution(String[] friends, String[] gifts) {
        int answer = Integer.MIN_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        int[][] score = new int[friends.length][friends.length];
        int[] expectedGift = new int [friends.length];

        for(String friend : friends) {
            map.put(friend, 0);
        }

        for(int i=0; i<gifts.length; i++) {
            String[] arr = gifts[i].split(" ");
            map.put(arr[0], map.get(arr[0]) + 1);
            map.put(arr[1], map.get(arr[1]) - 1);
            int index1 = Arrays.asList(friends).indexOf(arr[0]);
            int index2 = Arrays.asList(friends).indexOf(arr[1]);
            score[index1][index2]++;
        }

        for (int i=0; i<score.length; i++) {
            for (int j=0; j<score.length; j++) {
                if (i==j) continue;
                if (score[i][j] > score[j][i]) expectedGift[i]++;
                else if (((score[i][j] == 0 && score[j][i] == 0) || (score[i][j] == score[j][i]))
                        && map.get(friends[i]) > map.get(friends[j])) {
                    expectedGift[i]++;
                }
            }
        }

        for (int i=0; i<expectedGift.length; i++) {
            answer = Math.max(expectedGift[i], answer);
        }

        return answer;
    }
}
