package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] team = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int win_team;
        int min_time;
        int[] score = {0, 0};
        Record[] records = new Record[n];

        for (int i = 0; i < n; i++) {
            win_team = Integer.parseInt(st.nextToken());
            String tmp = st.nextToken();
            String[] time = tmp.split(":");
            min_time = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            records[i] = new Record(win_team, min_time);
        }

        for (int i = 1; i < n; i++) {

        }

    }
}

class Record {
    int team;
    int time;

    public Record(int team, int time) {
        this.team = team;
        this.time = time;
    }
}