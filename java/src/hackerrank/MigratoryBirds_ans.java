package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MigratoryBirds_ans {


    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        Map<Integer,Integer> mapList = new HashMap<Integer,Integer>() {{
            put(1,0);
            put(2,0);
            put(3,0);
            put(4,0);
            put(5,0);
        }};
        for (int i = 0; i < arr.size(); i++) {
            mapList.put(arr.get(i),mapList.get(arr.get(i)+1));
        }
        int countList[] = new int[5];
        for (int i : countList) {
            countList[i] = mapList.get(i);
        }
        Arrays.sort(countList);

        return countList[0];
    }
}
