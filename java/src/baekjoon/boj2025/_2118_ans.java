package baekjoon.boj2025;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2118_ans {
    private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
        return new StringTokenizer(bufferedReader.readLine());
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer stringTokenizer = receiveInput(bufferedReader);
        int N = parseInt(stringTokenizer.nextToken());

        int[] distances = new int[N * 2];
        int totalDistance = 0;
        for (int i = 0; i < N; i++) {
            distances[i] = Integer.parseInt(bufferedReader.readLine());
            distances[i + N] = distances[i]; // 환형 배열 처리
            totalDistance += distances[i];
        }

        int start = 0;
        int end = 0;
        int maxDistance = 0;
        int currentDistance = 0;

        for (start = 0; start < N; start++) {
            // 종료점을 이동시키며 최적의 위치를 찾음
            while (end < start + N && currentDistance + distances[end % N] <= totalDistance / 2) {
                currentDistance += distances[end % N];
                end++;
            }

            int distanceClockwise = currentDistance;  // 시계 방향 거리
            int distanceCounterClockwise = totalDistance - distanceClockwise;

            maxDistance = Math.max(maxDistance, Math.min(distanceClockwise, distanceCounterClockwise));   // 최대 거리 업데이트

            currentDistance -= distances[start];  // 시작점을 이동시키며 거리 갱신
        }

        System.out.println(maxDistance);

    }

}
