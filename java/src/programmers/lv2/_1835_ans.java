package programmers.lv2;

import java.util.*;

public class _1835_ans {
    private char[] people = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private boolean[] check = {false, false, false, false, false, false, false, false};
    private List<Character> orderList = new ArrayList<>();
    private String[] data;
    private int N;
    private int answer = 0;

    public int solution(int n, String[] data) {
        this.data = data;
        this.N = n;
        permutation(0);
        return answer;
    }

    private int find(Character ch) {
        return orderList.indexOf(ch);
    }
    private boolean isAnswer() {
        for (int i=0; i<N; i++) {
            int diff = Math.abs(find(data[i].charAt(0))-find(data[i].charAt(2)))-1;
            int expected = data[i].charAt(4)-'0';
            char op = data[i].charAt(3);
            if ((op == '=') && (diff != expected)) {
                return false;
            }
            else if ((op == '<') && (diff >= expected)) {
                return false;
            }
            else if((op == '>') && (diff <= expected)) {
                return false;
            }
        }
        return true;
    }

    private void permutation(int index) {
        if(orderList.size() == 8) {
            if(isAnswer()){
                answer += 1;
            }
            return;
        }

        for(int i=0; i<8 ;i++) {
            if(check[i]) continue;
            check[i] = true;
            orderList.add(people[i]);
            permutation(i);
            orderList.remove(orderList.size()-1);
            check[i] = false;
        }

    }
}
