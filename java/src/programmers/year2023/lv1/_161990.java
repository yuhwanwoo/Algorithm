package programmers.year2023.lv1;

public class _161990 {
    public static void main(String[] args) {

//        String[] wallpaper = {".#...", "..#..", "...#."};
//        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
//        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] wallpaper = {"..", "#."};
        solution(wallpaper);

    }

    public static int[] solution(String[] wallpaper) {
        int minX = wallpaper.length;
        int minY = wallpaper[0].length();
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char now = wallpaper[i].charAt(j);
                if (now == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        System.out.println(minX + " " + minY + " " + maxX + " " + maxY);

        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }
}
