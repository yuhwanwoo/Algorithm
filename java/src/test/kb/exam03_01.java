package test.kb;

import java.util.HashMap;

public class exam03_01 {
    public static boolean[] timeline;
    public static HashMap<String, Integer> days = new HashMap<>();
    public static int answer;

    public static void main(String[] args) {
        String[][] schedule = {{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"}, {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"}, {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"}, {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"}, {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}};
        System.out.println(solution(schedule));
    }

    public static int solution(String[][] schedule) {

        int a = 24*2*5;
        timeline = new boolean[24*2*5];
        days.put("MO", 0);
        days.put("TU", 24);
        days.put("WE", 48);
        days.put("TH", 72);
        days.put("FR", 96);
        dfs(schedule,0);
        System.out.println(answer);
        return answer;
    }
    public static void dfs(String[][] schedule, int idx){
        if(idx == 5){
            answer++;
            return;
        }
        for(int i=0; i<4; i++){
            //3시간 수업
            String tmp = schedule[idx][i];
            if(tmp.length() <= 8){
                String day = tmp.substring(0,2);
                //30분 단위로 일주일을 나눔
                int hour = Integer.parseInt(tmp.substring(3,5));
                int minute = tmp.substring(6,8).equals("30")? 1 : 0;
                int time = (days.get(day)+hour)*2+minute;

                //시간이 겹치면 다음 수업으로
                boolean check = true;
                for(int k=time; k<time+6; k++){
                    if(timeline[k]){
                        check = false;
                        break;
                    }
                }
                if(!check) continue;

                //타임라인 체크
                for(int k=time; k<time+6; k++) timeline[k] = true;

                dfs(schedule, idx+1);

                //타임라인 체크 해제
                for(int k=time; k<time+6; k++) timeline[k] = false;

            }
            //1시간 반 2번
            else{
                String first = tmp.substring(0,8);
                String second = tmp.substring(9);

                String day1 = first.substring(0,2);
                String day2 = second.substring(0,2);

                int hour1 = Integer.parseInt(first.substring(3,5));
                int hour2 = Integer.parseInt(second.substring(3,5));
                int minute1 = first.substring(6,8).equals("30")? 1 : 0;
                int minute2 = second.substring(6,8).equals("30")? 1 : 0;
                int time1 = (days.get(day1)+hour1)*2+minute1;
                int time2 = (days.get(day2)+hour2)*2+minute2;

                boolean check = true;
                for(int k=time1; k<time1+3; k++){
                    if(timeline[k]){
                        check = false;
                        break;
                    }
                }
                for(int k=time2; k<time2+3; k++){
                    if(timeline[k]){
                        check = false;
                        break;
                    }
                }
                if(!check) continue;

                for(int k=time1; k<time1+3; k++) timeline[k] = true;
                for(int k=time2; k<time2+3; k++) timeline[k] = true;

                dfs(schedule, idx+1);

                for(int k=time1; k<time1+3; k++) timeline[k] = false;
                for(int k=time2; k<time2+3; k++) timeline[k] = false;
            }
        }
    }
}
