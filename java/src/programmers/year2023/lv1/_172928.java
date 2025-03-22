package programmers.year2023.lv1;

import java.util.Arrays;

public class _172928 {

    private static String[][] allRoutes;
    private static int[] start = new int[2];

    public static void main(String[] args) {
        // t1
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 3","S 2","W 1"};

        solution(park, routes);

        // t2
        park = new String[]{"SOO","OXX","OOO"};
        routes = new String[]{"E 2","S 2","W 1"};

//        solution(park, routes);

        // t3
        park = new String[]{"OSO","OOO","OXO","OOO"};
        routes = new String[]{"E 2","S 3","W 1"};

//        solution(park, routes);


    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        allRoutes = new String[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            allRoutes[i] = park[i].split("");
            for (int j = 0; j < park[i].length(); j++) {
                if (allRoutes[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        for (String route : routes) {
            String[] split = route.split(" ");
            String direction = split[0];
            int distance = Integer.parseInt(split[1]);
            validateRoute(direction, distance);
            System.out.println(start[0] + " " + start[1]);
        }
        System.out.println("==========================");

        System.out.println(start[0] + " " + start[1]);

        return answer;
    }

    private static void validateRoute(String direction, int distance) {
        String now = "";
        if (direction.equals("N")) {
            if (start[0] - distance < 0) {
                return;
            }
            for (int i = 1; i <= distance; i++) {
                now = allRoutes[start[0] - i][start[1]];
                if(now.equals("X")) {
                    return;
                }
            }
            start[0] = start[0] - distance;
        }

        if (direction.equals("S")) {
            if (start[0] + distance >= allRoutes.length) {
                return;
            }
            for (int i = 1; i <= distance; i++) {
                now = allRoutes[start[0] + i][start[1]];
                if(now.equals("X")) {
                    return;
                }
            }
            start[0] = start[0] + distance;
        }

        if (direction.equals("W")) {
            if (start[1] - distance < 0) {
                return;
            }
            for (int i = 1; i <= distance; i++) {
                now = allRoutes[start[0]][start[1] - i];
                if(now.equals("X")) {
                    return;
                }
            }
            start[1] = start[1] - distance;
        }

        if (direction.equals("E")) {
            if (start[1] + distance >= allRoutes[start[0]].length) {
                return;
            }
            for (int i = 1; i <= distance; i++) {
                now = allRoutes[start[0]][start[1] + i];
                if(now.equals("X")) {
                    return;
                }
            }
            start[1] = start[1] + distance;
        }
    }
}
