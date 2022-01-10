package test;

public class arrToarr {
    public static void main(String[] args) {
        System.out.println(rep("[[0,2],[2,3],[3,2],[5,3],[6,2],[7,3],[9,4],[10,2],[11,2],[12,4],[14,2],[15,3],[16,2]]"));
    }

    public static String rep(String s) {

        s = s.replace("[","{");

        s = s.replace("]","}");

        return s;
    }
}
