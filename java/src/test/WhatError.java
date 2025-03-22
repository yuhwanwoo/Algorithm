package test;

import java.util.*;
import java.io.*;


public class WhatError {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, String> map = new HashMap<>();
        map.put('0', "1110111");
        map.put('1', "0010001");
        map.put('2', "1011110");
        map.put('3', "1011011");
        map.put('4', "0111001");
        map.put('5', "1101011");
        map.put('6', "1101111");
        map.put('7', "1110001");
        map.put('8', "1111111");
        map.put('9', "1111011");
        map.put(' ', "0000000");
        int t = Integer.parseInt(br.readLine());
        while (t != 0) {
            st = new StringTokenizer(br.readLine());
            String firstInput = st.nextToken();
            String secondInput = st.nextToken();
            int answer = 0;

            firstInput = firstInput.length() == 5 ? firstInput : " ".repeat(5 - firstInput.length()) + firstInput;
            secondInput = secondInput.length() == 5 ? secondInput : " ".repeat(5 - secondInput.length()) + secondInput;
            for (int i = 0; i < 5; i++) {
                char fromChar = firstInput.charAt(i);
                char toChar = secondInput.charAt(i);
                String from = map.get(fromChar);
                String to = map.get(toChar);

                for (int j = 0; j < 7; j++) {
                    if (from.charAt(j) != to.charAt(j)) {
                        answer += 1;
                    }
                }
            }
            bw.write(answer + "");
            bw.write("\n");

            t--;
        }
        bw.close();
    }
}
