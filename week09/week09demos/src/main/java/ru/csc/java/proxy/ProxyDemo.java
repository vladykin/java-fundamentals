package ru.csc.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ProxyDemo {

    public static void main(String[] args) throws Exception {
        Future future = (Future) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Runnable.class, Callable.class, Future.class},
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long start = System.currentTimeMillis();
                //System.out.printf("%s(%s)%n", method.getName(), Arrays.toString(args));
                //invoke delegate
                System.out.println(System.currentTimeMillis() - start);
                return null;
            }
        });

        future.cancel(true);
    }
}
