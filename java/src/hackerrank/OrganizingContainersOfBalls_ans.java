package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OrganizingContainersOfBalls_ans {
    public static void main(String[] args) {

    }

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        /*
        0 2
        1 1

         */

        Map<Integer, Integer> countOfBallForType = new HashMap<>();
        List<Integer> countOfBallInContainer = new ArrayList<>();

        for (List<Integer> c : container) {
            countOfBallInContainer.add(c.stream().reduce((i, j) -> i + j).get()); // 각 컨테이너에 저장된 볼의 총 갯수
            IntStream.range(0, c.size()) // 볼 타입 별 갯수
                    .forEach(i -> countOfBallForType.put(i, countOfBallForType.getOrDefault(i, 0) + c.get(i)));
        }


        for (int ballCount : countOfBallInContainer) {
            Iterator<Integer> iterator = countOfBallForType.keySet().iterator();
            while (iterator.hasNext()) {
                int key = iterator.next();
                if (countOfBallForType.get(key) == ballCount) {
                    countOfBallForType.remove(key);
                    break;
                }
            }
        }

        return countOfBallForType.isEmpty() ?  "Possible" : "Impossible";
    }
}
