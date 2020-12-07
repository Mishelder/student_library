package by.misha;

public class A {
    static {
        System.out.print("static-A, ");
    }
    {
        System.out.print("init-A, ");
    }
    public A() {
        System.out.print("constructor-A, ");
    }
}

