package test;

import java.util.Objects;

public class EqualsTest {
    public static void main(String[] args) {
        Ball a = new Ball("1");
        Ball b = new Ball("1");

        String c = "1";
        String d = "1";

        System.out.println("a==b: " + (a == b));
        System.out.println("a.equals(b): " + a.equals(b));
        System.out.println("a.hashCode(): " + a.hashCode());
        System.out.println("b.hashCode(): " + b.hashCode());

        System.out.println("c == d: " + (c == d));
        System.out.println("c.equals(d): " + c.equals(d));
    }
}

class Ball {
    String name;

    public Ball(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (name == ((Ball)o).name) {
            return true;
        }

        return false;
    }
}
