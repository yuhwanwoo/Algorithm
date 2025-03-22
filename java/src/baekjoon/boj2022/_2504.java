package baekjoon.boj2022;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class _2504 {

    static Stack<String> stk = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();

        int cCnt = 0; // ()
        int eCnt = 0; // []

        for (int i = 0; i < size; i++) {
            String now = input.charAt(i) + "";

            if (now.equals("(")) {
                cCnt += 1;
                stk.add(now);
            }
            if (now.equals(")")) {
                cCnt -= 1;
                if (stk.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                String top = stk.peek();
                if (top.equals("(")) {
                    stk.pop();
                    stk.add("2");
                } else {
                    int roundResult = 0;

                    while (!stk.isEmpty()) {

                        if (stk.peek().equals("[")) {
                            System.out.println(0);
                            return;
                        } else if (stk.peek().equals("(")) {
                            stk.pop();
                            roundResult *= 2;
                            stk.push(String.valueOf(roundResult));
                            break;
                        } else {
                            roundResult += Integer.parseInt(stk.pop());
                        }

                    }
                }
            }
            if (now.equals("[")) {
                eCnt += 1;
                stk.add(now);
            }
            if (now.equals("]")) {
                eCnt -= 1;
                if (stk.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                String top = stk.peek();
                if (top.equals("[")) {
                    stk.pop();
                    stk.add("3");
                } else {
                    int squareResult = 0;

                    while (!stk.isEmpty()) {

                        if (stk.peek().equals("(")) {
                            System.out.println(0);
                            return;
                        } else if (stk.peek().equals("[")) {
                            stk.pop();
                            squareResult *= 3;
                            stk.push(String.valueOf(squareResult));
                            break;
                        } else {
                            squareResult += Integer.parseInt(stk.pop());
                        }
                    }
                }
            }

            if (cCnt < 0 || eCnt < 0) {
                System.out.println(0);
                return;
            }
        }

        if(eCnt != 0 || cCnt != 0) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        while (!stk.isEmpty()) {
            answer += Integer.parseInt(stk.pop());
        }

        System.out.println(answer);
    }
}
