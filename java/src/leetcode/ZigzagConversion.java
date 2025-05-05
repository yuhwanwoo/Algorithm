package leetcode;

import java.util.ArrayList;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        convert(s, numRows);
    }

    public static String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> chars = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            chars.add(new ArrayList<>());
        }

        if (numRows == 1) {
            return s;
        }

        int index = 0;
        boolean downFlag = true;
        for (int i = 0; i < s.length(); i++) {
            if (downFlag) {
                chars.get(index).add(s.charAt(i));

                if (index == numRows - 1) {
                    downFlag = false;
                    index--;
                    continue;
                }
                index++;
            }
            if (!downFlag) {
                chars.get(index).add(s.charAt(i));
                if (index == 0) {
                    downFlag = true;
                    index++;
                    continue;
                }
                index--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            for (int j = 0; j < chars.get(i).size(); j++) {
                sb.append(chars.get(i).get(j));
            }
        }

        return sb.toString();
    }
}
