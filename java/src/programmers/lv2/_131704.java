package programmers.lv2;

import java.util.Stack;

public class _131704 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        solution(order);
    }

    public static int solution(int[] order) {
        int answer = 0;
        int index = 0;

        Stack<Integer> belt = new Stack<>();

        for(int i=1;i<=order.length;i++){
            belt.push(i);

            while(!belt.isEmpty()){
                if(belt.peek()==order[index]){
                    belt.pop();
                    index++;
                    answer++;
                }
                else {
                    break;
                }
            }
        }
        return answer;
    }
}
