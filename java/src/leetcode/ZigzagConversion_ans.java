package leetcode;

import java.util.ArrayList;

public class ZigzagConversion_ans {
    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();

        for(int i=0; i<numRows; i++)
            list.add(new ArrayList<Character>());

        int row = 0;//행
        int zig = numRows-2;//대각선으로 써야하는 횟수
        int zigIdx = 1;//대각선 문자를 어느행에 쓸지 알려줄 인덱스
        for(int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);
            //세로와 대각선을 한번씩 다썼으면 인덱스와 횟수 처음으로 초기화
            if(row>=numRows && zig<=0) {
                row = 0;
                zig = numRows-2;
                zigIdx = 1;
            }
            //세로한줄 먼저쓰기
            if(row<numRows) {
                list.get(row).add(temp);
                row++;
                continue;
            }

            //대각선으로 쓰기
            if(zig>0) {
                list.get(row-zigIdx-1).add(temp);
                zig--;
                zigIdx++;
            }
        }

        StringBuilder sb = new StringBuilder();//정답
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                sb.append(list.get(i).get(j));
            }
        }

        return sb.toString();
    }
}
