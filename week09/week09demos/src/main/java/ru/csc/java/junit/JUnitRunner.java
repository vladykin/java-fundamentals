package ru.csc.java.junit;

import com.google.common.reflect.ClassPath;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

public class JUnitRunner {

    public static void main(String[] args) throws Exception {
        String packageName = args[0];
        Set<ClassPath.ClassInfo> classesInPackage =
                ClassPath.from(ClassLoader.getSystemClassLoader())
                        .getTopLevelClasses(packageName);

        for (ClassPath.ClassInfo classInfo : classesInPackage) {
            if (classInfo.getSimpleName().contains("Test")) {
                executeTest(classInfo.load());
            }
        }
    }

    private static void executeTest(Class<?> testClass) throws Exception {
        for (Method method : testClass.getMethods()) {
            if (isTestMethod(method)) {
                System.out.println("Invoking " + method);
                Object testInstance = testClass.getConstructor().newInstance();
                method.invoke(testInstance);
            }
        }
    }

    private static boolean isTestMethod(Method method) {
        return method.getParameterCount() == 0
                && method.getReturnType().equals(void.class)
                && (method.getModifiers() & Modifier.STATIC) == 0
                && method.getAnnotation(Test.class) != null;
    }
}
