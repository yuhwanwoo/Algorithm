package programmers.year2023.lv1;

import java.util.ArrayList;
import java.util.HashMap;

public class _131128 {
    public static void main(String[] args) {
        String X = "100";
        String Y = "2345";

        X = "100";
        Y = "203045";

        X = "100";
        Y = "123450";

        X = "12321";
        Y = "42531";

        X = "5525";
        Y = "1255";

        solution(X, Y);
    }

    public static String solution(String X, String Y) {
        String answer = "";
        String[] xArray = X.split("");
        String[] yArray = Y.split("");
        HashMap<String, Integer> xMap = new HashMap<>();
        HashMap<String, Integer> yMap = new HashMap<>();

        for (int i = 0; i < xArray.length; i++) {
            String input = xArray[i];
            String key = "x" + input;
            if (!xMap.containsKey(key)) {
                xMap.put(key, 0);
            }
            xMap.put(key, xMap.get(key) + 1);
        }

        for (int i = 0; i < yArray.length; i++) {
            String input = yArray[i];
            String key = "y" + input;
            if (!yMap.containsKey(key)) {
                yMap.put(key, 0);
            }
            yMap.put(key, yMap.get(key) + 1);
        }
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 9; i >= 0; i--) {
            String xKey = "x" + i;
            String yKey = "y" + i;
            if (i == 0 && arr.size() == 0 && (xMap.containsKey(xKey) && yMap.containsKey(yKey))) {
                arr.add("0");
                break;
            }
            if (xMap.containsKey(xKey) && yMap.containsKey(yKey)) {
                int count = xMap.get(xKey) > yMap.get(yKey) ? yMap.get(yKey) : xMap.get(xKey);
                for (int j = 0; j < count; j++) {
                    arr.add(String.valueOf(i));
                }
            }
        }
        if (arr.size() == 0) {
            arr.add("-1");
        }
        answer = String.join("", arr);
        return answer;
    }

}
