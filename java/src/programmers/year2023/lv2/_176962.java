package programmers.year2023.lv2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class _176962 {
    static Stack<Subject> stk;

    public static void main(String[] args) {
//        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
//        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
//        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
//        String[][] plans = {{"aaa", "12:00", "30"}, {"bbb", "12:10", "30"}, {"ccc", "14:00", "30"}}; // bbb,aaa,ccc
//        String[][] plans = {{"music", "12:20", "40"}, {"computer", "12:30", "100"}, {"science", "12:40", "50"}, {"history", "14:00", "30"}}; //
//        String[][] plans = {{"music", "12:00", "60"}, {"computer", "12:10", "30"}, {"science", "12:20", "30"}, {"history", "14:00", "30"}}; //
        String[][] plans = {{"1", "00:00", "30"}, {"2", "00:10", "10"}, {"3", "00:30", "10"}, {"4", "00:50", "10"}}; // 2, 3, 1, 4
        solution(plans);
    }

    public static String[] solution(String[][] plans) {
        PriorityQueue<Subject> pq = new PriorityQueue<>();
        for (String[] plan : plans) {
            String[] time = plan[1].split(":");
            pq.add(new Subject(plan[0], Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]), Integer.parseInt(plan[2])));
        }

        stk = new Stack<>();
        ArrayList<String> answerList = new ArrayList<>();
        int nowTime = pq.peek().time;

        while (!pq.isEmpty()) {
            Subject top = pq.poll();

            //{{"aaa", "12:00", "30"}, {"bbb", "12:10", "30"}, {"ccc", "14:00", "30"}}; // bbb,aaa,ccc
            if (!pq.isEmpty()) {
                Subject peek = pq.peek();
                if (top.time + top.spareTime <= peek.time) {
                    answerList.add(top.name);
                    nowTime = top.time + top.spareTime;
//                    System.out.println("nowTime1 = " + nowTime);
                    while (!stk.isEmpty()) {
                        if (nowTime == peek.time) {
                            break;
                        }

                        Subject pop = stk.pop();
                        for (int i = nowTime; i <= nowTime + pop.spareTime; i++) {
                            if (i == nowTime + pop.spareTime) {
                                answerList.add(pop.name);
                                nowTime = i;
                                break;
                            }
                            if (i == peek.time) {
                                stk.add(new Subject(pop.name, pop.time, pop.spareTime - (i - nowTime)));
                                nowTime = i;
                                break;
                            }
                        }
                    }
                } else if (top.time + top.spareTime > peek.time) {
                    nowTime += (peek.time - top.time);
                    stk.add(new Subject(top.name, top.time, top.time + top.spareTime - peek.time));
                }
            } else {
                if (nowTime == top.time) {
                    answerList.add(top.name);
                    while (!stk.isEmpty()) {
                        answerList.add(stk.pop().name);
                    }
                } else {
                    boolean flag = false;
                    while (!stk.isEmpty()) {
                        Subject pop = stk.pop();
                        for (int i = nowTime; i <= nowTime + pop.spareTime; i++) {
                            nowTime = i;
                            if (i == nowTime + pop.spareTime) {
                                answerList.add(pop.name);
                            }
                            if (nowTime == top.time && !flag) {
                                answerList.add(top.name);
                                flag = true;
                            }
                        }
                    }
                    if (!flag) {
                        answerList.add(top.name);
                    }
                }
            }
        }
        System.out.println("answerList = " + answerList);
        return answerList.toArray(new String[0]);
    }

    private static class Subject implements Comparable<Subject> {
        private String name;
        private int time;
        private int spareTime;

        @Override
        public int compareTo(Subject s) {
            return this.time - s.time;
        }

        public Subject(String name, int time, int spareTime) {
            this.name = name;
            this.time = time;
            this.spareTime = spareTime;
        }

        @Override
        public String toString() {
            return "Subject{" +
                    "name='" + name + '\'' +
                    ", spareTime=" + spareTime +
                    '}';
        }
    }
}
