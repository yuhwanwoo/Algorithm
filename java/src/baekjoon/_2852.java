package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int win_team;
        int min_time;
        int[] score = {0, 0};
        int[] ans_time = {0, 0};
        Record[] records = new Record[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            win_team = Integer.parseInt(st.nextToken());
            String tmp = st.nextToken();
            String[] time = tmp.split(":");
            min_time = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            records[i] = new Record(win_team, min_time);
        }

        win_team = records[0].team;
        score[win_team - 1] += 1;
        min_time = records[0].time;

        for (int i = 1; i < n; i++) {
            int tmp_team = records[i].team;
            int tmp_time = records[i].time;
            if (score[0] > score[1]) {
                ans_time[0] += (tmp_time - min_time);
            }
            if (score[0] < score[1]) {
                ans_time[1] += (tmp_time - min_time);
            }
            score[tmp_team - 1] += 1;

            min_time = tmp_time;

        }

        if (score[0] > score[1]) {
            ans_time[0] += (48 * 60 - min_time);
        }
        if (score[0] < score[1]) {
            ans_time[1] += (48 * 60 - min_time);
        }

        for (int i = 0; i < 2; i++) {
            int h = ans_time[i] / 60;
            int m = ans_time[i] % 60;
            String hour;
            String min;
            if (h < 10) {
                hour = "0" + Integer.toString(h);
            }else {
                hour = Integer.toString(h);
            }

            if (m < 10) {
                min = "0" + Integer.toString(m);
            }else {
                min = Integer.toString(m);
            }

            System.out.println(hour + ":" + min);

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