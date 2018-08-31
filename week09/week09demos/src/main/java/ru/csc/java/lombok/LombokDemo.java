package ru.csc.java.lombok;

public class LombokDemo {

    public static void main(String[] args) {
        MyBean b1 = MyBean.of("a", "b");
        MyBean b2 = MyBean.of("a", "b");
        if (b1.equals(b2)) {
            System.out.println("Equals");
        } else {
            System.out.println("Not equals");
        }
    }
}
