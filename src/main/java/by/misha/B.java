package by.misha;

import java.io.IOException;

public class B extends A {
    static {
        System.out.print("static-B, ");
    }
    {
        System.out.print("init-B, ");
    }
    public B(){
        System.out.print("Constructor-B, ");
    }
}