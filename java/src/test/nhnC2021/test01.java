package test.nhnC2021;

import java.util.*;
import java.util.Scanner;

public class test01 {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt(); // 송수신 기록의 수
        String[] logs = new String[n + 1]; // 송수신 기록
        for(int i = 0 ; i < n + 1 ; i ++)
        {
            logs[i] = scanner.nextLine().trim();
        }

        ArrayList<String> answer = new ArrayList<>();

        for(int i = 1; i < n + 1; i++) {
//            System.out.println(logs[i]);
            String[] log = logs[i].split(" ");
            String now_code = log[0];
            String now_num = log[1];
            int j = i + 1;
            int cnt = 0;

            while (j < n){
                String[] tmp_log = logs[j].split(" ");
                String tmp_log_code = tmp_log[0];
                String tmp_log_num = tmp_log[1];
                if(now_code.equals(tmp_log_code) && now_num.equals(tmp_log_num)) {
                    cnt += 1;
                }else {
                    break;
                }
                j += 1;
            }
            if (cnt != 0) {
                i += cnt;
                answer.add(now_code + " " + now_num + " (" + (cnt + 1) + ")");
            }else {
                answer.add(now_code + " " + now_num);
            }
            if (i >= n) {
                break;
            }
        }
        int size = answer.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(answer.get(i));
        }

    }
}
