package test.kb;

import java.util.ArrayList;

public class exam03 {
    static String[] dateMap = {"MO", "TU", "WE", "TH", "FR"};
    static ArrayList<Time> arr = new ArrayList<>();
    static int ans = 0;

    public static void main(String[] args) {
        String[][] schedule = {{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"}, {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"}, {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"}, {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"}, {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}};
        System.out.println(solution(schedule));
    }

    static int solution(String[][] schedule) {
        dfs(0, schedule);
        return ans;
    }

    static void dfs(int idx, String[][] schedule) {
        if (idx == 4) {
            ans++;
            return;
        }

        int cnt;
        for (int j = 0; j < 4; j++) {
            if (schedule[idx][j].length() != 8) { // 추가한 갯수 확인
                cnt = 2;
            }else {
                cnt = 1;
            }

            if (dateToTime(schedule[idx][j]) == false) {
                continue;
            } else {
                dfs(idx + 1, schedule);
                // 추가한 만큼 지우기
                for (int k = 0; k < cnt; k++) {
                    arr.remove(arr.size() - 1);
                }
            }
        }
    }

    static boolean dateToTime(String date) {
        String day;
        int hour, minute, time1 = 0, time2 = 0, add = 180;
        Time t;

        if (date.length() == 8) { // 하루 1시간반
            day = date.substring(0, 2);
            hour = Integer.parseInt(date.substring(3, 5));
            minute = Integer.parseInt(date.substring(6, 8));
            time1 = dayToTime(day);
            time1 += hour * 60 + minute;

            for (int k = 0; k < arr.size(); k++) {
                t = arr.get(k);
                if (!(t.s > time1 + add || t.e < time1)) {
                    return false;
                }
            }

            arr.add(new Time(time1, time1 + add));
        } else {
            add = 90;
            day = date.substring(0, 2);
            hour = Integer.parseInt(date.substring(3, 5));
            minute = Integer.parseInt(date.substring(6, 8));
            time1 = dayToTime(day);
            time1 += hour * 60 + minute;

            day = date.substring(9, 11);
            hour = Integer.parseInt(date.substring(12, 14));
            minute = Integer.parseInt(date.substring(15, 17));
            time2 = dayToTime(day);
            time2 += hour * 60 + minute;

            for (int k = 0; k < arr.size(); k++) {
                t = arr.get(k);
                if (!(t.s > time1 + add || t.e < time1)) {
                    return false;
                }

                if (!(t.s > time2 + add || t.e < time2)) {
                    return false;
                }
            }

            arr.add(new Time(time1, time1 + add));
            arr.add(new Time(time2, time2 + add));
        }

        return true;
    }

    static int dayToTime(String day) { // 요일 idx
        int ans = 0;
        for (int i = 0; i < dateMap.length; i++) {
            if (day.equals(dateMap[i])) {
                ans = i * 1440;
                break;
            }
        }

        return ans;
    }

    static class Time {
        int s, e;

        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
