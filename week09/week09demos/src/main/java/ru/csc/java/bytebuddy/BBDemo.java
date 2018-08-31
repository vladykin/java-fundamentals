package ru.csc.java.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodCall;

import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BBDemo {

    public static void main(String[] args) throws Exception {

        DynamicType.Unloaded unloadedType = new ByteBuddy()
                .subclass(Object.class)
                .defineMethod("main", TypeDescription.VOID, Modifier.PUBLIC | Modifier.STATIC)
                .withParameters(String[].class)
                .intercept(MethodCall.invoke(PrintStream.class.getMethod("println", String.class))
                        .on(System.out)
                        .with("Hello world"))
                .make();

        Files.write(
                Paths.get("HelloWorld.class"),
                unloadedType.getBytes());

        DynamicType.Loaded loadedType = unloadedType.load(Thread.currentThread().getContextClassLoader());
        Class<?> generatedClass = loadedType.getLoaded();
        generatedClass.getMethod("main", String[].class).invoke(null, new Object[] {new String[0]});

    }
}
