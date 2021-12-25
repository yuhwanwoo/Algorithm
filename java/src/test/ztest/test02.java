package test.ztest;

import java.util.*;

public class test02 {
    public static void main(String[] args) {
//        int[][] data = {{1,0,5},{2,2,2},{3,3,1},{4,4,1},{5,10,2}};
//
//        solution(data);

        int[][] data1 = {{1,0,3}, {2,1,3},{3,3,2},{4,9,1},{5,10,2}};
        System.out.println(solution(data1));

        int[][] data2 = {{1,2,10}, {2,5,8}, {3,6,9}, {4,20,6}, {5,25,5}};
        solution(data2);
    }

    public static int[] solution(int[][] data) {

        int size = data.length;
        int[] answer = new int[size];
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<Data> datas = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int[] tmp = data[i];
            datas.add(new Data(tmp[0], tmp[1], tmp[2]));
        }

        ArrayList<Data> wait = new ArrayList<>();

        int time = 0;

        while (true) {
//            System.out.println("time: " + time);
            if (datas.size() == 0 && wait.size() == 0) {
                break;
            }

            for (int i = 0; i < datas.size(); i++) {
                Data tmp = datas.get(0);

                if (tmp.time <= time) {
                    datas.remove(0);
                    wait.add(new Data(tmp.num, tmp.time, tmp.page));
                }
            }

            Collections.sort(wait);

            if (wait.size() != 0) {
                Data now = wait.remove(0);

                time += now.page;
                ans.add(now.num);
                continue;
            }

            time += 1;
        }

        for (int i = 0; i < size; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}

class Data implements Comparable<Data>{
    int num;
    int time;
    int page;

    public Data(int num, int time, int page) {
        this.num = num;
        this.time = time;
        this.page = page;
    }

    @Override
    public int compareTo(Data o) {
        if (o.page == page) {
            return Integer.compare(time, o.time);
        } else {
            return Integer.compare(page, o.page);
        }
    }
}
