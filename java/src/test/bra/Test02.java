package test.bra;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Test02 {
    public static void main(String[] args) {
//        int[] ball = {1, 2, 3, 4, 5, 6};
//        int[] order = {6, 2, 5, 1, 4, 3};

        int[] ball = {11, 2, 9, 13, 24};
        int[] order = {9, 2, 13, 24, 11};

        solution(ball, order);
    }

    private static int[] solution(int[] ball, int[] order) {
        ArrayList<Integer> ansArrayList = new ArrayList<>();
        HashMap<Integer, Boolean> chkPoll = new HashMap<>();
        int[] answer = new int[ball.length];
        int idx = 0;
        Stack<Integer> stkCommand = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < ball.length; i++) {
            deque.add(ball[i]);
            chkPoll.put(ball[i], false);
            stkCommand.push(order[ball.length - i - 1]);
        }

        while (!stkCommand.isEmpty()) {
            int nowOrder = stkCommand.pop();
            if (chkPoll.get(deque.peekFirst())) {
//                ansArrayList.add(deque.removeFirst());
                answer[idx] = deque.removeFirst();
                idx++;
                stkCommand.push(nowOrder);
                continue;
            }
            // 오른쪽 보류인지 확인
            if (chkPoll.get(deque.peekLast())) {
//                ansArrayList.add(deque.removeLast());
                answer[idx] = deque.removeLast();
                idx++;
                stkCommand.push(nowOrder);
                continue;
            }
            if (deque.peekFirst() == nowOrder) {
//                ansArrayList.add(deque.removeFirst());
                answer[idx] = deque.removeFirst();
                idx++;
                continue;
            }

            if (deque.peekLast() == nowOrder) {
//                ansArrayList.add(deque.removeLast());
                answer[idx] = deque.removeLast();
                idx++;
                continue;
            }
            chkPoll.put(nowOrder, true);
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
        return answer;
    }
}
