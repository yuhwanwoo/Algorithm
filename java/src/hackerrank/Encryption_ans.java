package hackerrank;

public class Encryption_ans {
    public static void main(String[] args) {

    }

    public static void solve(String s) {
        int len = s.length();
        double rootLen = Math.sqrt(len);


        int ip = (int) rootLen;


        double fp = rootLen - ip;


        int rows, columns = 0;


        if (fp > 0) {


            rows = ip;


            columns = ip + 1;


            while (rows * columns < len) {


                rows = rows + 1;


            }


        } else if (fp == 0) {


            rows = columns = ip;


        }


        int start = 0;


        while (start < columns) {


            for (int i = start; i < len; i = i + columns) {


                System.out.print(s.charAt(i));


            }


            start++;


            System.out.print(" ");


        }


    }

}
