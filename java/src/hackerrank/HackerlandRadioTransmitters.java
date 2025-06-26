package hackerrank;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;

public class HackerlandRadioTransmitters {
    public static void main(String[] args) {
        hackerlandRadioTransmitters(List.of(1, 2, 3, 5, 9), 1);
        hackerlandRadioTransmitters(List.of(7, 2, 4, 6, 5, 9, 12, 11), 2);
    }

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        // Write your code here

        x = x.stream().sorted().toList();
        int answer = 0;
        int idx = 0;
        int n = x.size();

        while (idx < n) {
            answer++;

            int lastCover = x.get(idx) + k;
            while (idx < n && x.get(idx) <= lastCover) {
                idx++;
            }

            int rightLastCover = x.get(idx - 1) + k;

            while (idx < n && x.get(idx) <= rightLastCover) {
                idx++;
            }

        }

        return answer;
    }
}
