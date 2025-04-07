package hackerrank;

public class RecursiveDigitSum {
    public static void main(String[] args) {

    }

    public static int superDigit(String n, int k) {
        // Write your code here
        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += (n.charAt(i) - '0');
        }

        return (int) dfs(sum * k);
    }

    private static long dfs(long n) {
        if (n < 10) {
            return n;
        }

        long init = 0;
        while (n > 0) {
            long mod = n % 10;
            n /= 10;
            init += mod;
        }

        return dfs(init);
    }
}
