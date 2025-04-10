package etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Oho01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3, 1, 2};
        int[][] target = {{1, 2}, {2, 3}, {1, 3}};

        List<Integer> result = solution(arr, target);
        System.out.println(result); // 예상 출력: [1, 3, 1]
    }

    private static List<Integer> solution(int[] arr, int[][] target) {
        List<Integer> answer = new ArrayList<>();

        // 색깔 별 인덱스를 미리 저장
        Map<Integer, List<Integer>> colorPositions = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            colorPositions.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // 각 쌍에 대해 최소 거리 계산
        for (int[] pair : target) {
            int colorA = pair[0];
            int colorB = pair[1];

            List<Integer> positionsA = colorPositions.get(colorA);
            List<Integer> positionsB = colorPositions.get(colorB);

            int minDist = Integer.MAX_VALUE;

            // 두 리스트를 투 포인터 방식으로 최소 거리 계산
            int i = 0, j = 0;
            while (i < positionsA.size() && j < positionsB.size()) {
                int posA = positionsA.get(i);
                int posB = positionsB.get(j);
                minDist = Math.min(minDist, Math.abs(posA - posB));

                // 포인터 이동
                if (posA < posB) {
                    i++;
                } else {
                    j++;
                }
            }

            answer.add(minDist);
        }

        return answer;
    }
}
