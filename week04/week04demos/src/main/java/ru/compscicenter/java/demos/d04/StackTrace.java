package ru.compscicenter.java.demos.d04;

import java.util.Arrays;

public class StackTrace {

    public static void main(String[] args) {
//        StackTraceElement[] stackTrace1 = new Exception().getStackTrace();
//        System.out.println(Arrays.asList(stackTrace1));

//        StackTraceElement[] stackTrace2 = Thread.currentThread()
//                .getStackTrace();
//        System.out.println(Arrays.asList(stackTrace2));


        StackWalker.StackFrame[] stackTrace3 =
                StackWalker.getInstance().walk(s -> s.limit(3).toArray(StackWalker.StackFrame[]::new));
        System.out.println(Arrays.asList(stackTrace3));
    }
}
