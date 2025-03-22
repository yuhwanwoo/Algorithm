package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class _1283 {

    static ArrayList<String> answer = new ArrayList<>();
    static HashSet<Character> set = new HashSet<>();
    static String temp = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            temp = "";
//            System.out.println(input + " " + temp);
            if (chkPre(input)) {
                answer.add(temp);
            } else if(checkEntry(input)) {
                answer.add(temp);
            }else{
                answer.add(input);
            }

        }
        for (String s : answer) {
            System.out.println(s);
        }
    }

    private static boolean checkEntry(String input) {
        boolean flag = false;
//        System.out.println("temp: " + temp);
        temp = "";

        for(int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if(flag) {
                temp += now;
            }else {
                if(now == ' ') {
                    temp += " ";
                    continue;
                }
                if (set.contains(Character.toUpperCase(now))) {
                    temp += now;
                } else {
                    set.add(Character.toUpperCase(now));
                    temp += ("[" + now + "]");
                    flag = true;
                }
            }

        }
        return flag;
    }

    public static boolean chkPre(String input) {
        String[] spl = input.split(" ");

        boolean flag = false;

        for (int i = 0; i < spl.length; i++) {
            if (flag) {
                temp += (spl[i] + " ");
            }else {
                if (set.contains(Character.toUpperCase(spl[i].charAt(0)))) {
                    temp += (spl[i] + " ");
                } else{
                    set.add(Character.toUpperCase(spl[i].charAt(0)));
                    temp += ("[" + spl[i].charAt(0) + "]" + spl[i].substring(1, spl[i].length()) + " ");
                    flag = true;
                }
            }

        }

        return flag;
    }
}
