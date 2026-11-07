package programmers.year2026.hkr.medium;

import java.util.List;

public class GridSearch_ans {

    public static String gridSearch(List<String> G, List<String> P) {
        int R = G.size();
        int C = G.get(0).length();

        int r = P.size();
        int c = P.get(0).length();

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {

                boolean matched = true;

                for (int k = 0; k < r; k++) {
                    String gridPart = G.get(i + k)
                            .substring(j, j + c);

                    if (!gridPart.equals(P.get(k))) {
                        matched = false;
                        break;
                    }
                }

                if (matched) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

}
