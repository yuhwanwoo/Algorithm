package hackerrank;

public class CatsAndAMouse_ans {
    public static void main(String[] args) {

    }

    static String catAndMouse(int x, int y, int z) {
        var a = Math.abs(x - z);
        var b = Math.abs(y - z);

        if (a < b) {
            return "Cat A";
        } else if (a > b) {
            return "Cat B";
        } else {
            return "Mouse";
        }
    }
}
