package ru.csc.java.asm;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.objectweb.asm.Opcodes.*;

public class ClassGenerator {

    public static void main(String[] args) throws Exception {
        ClassWriter cw = new ClassWriter(0);

        cw.visit(V1_8, ACC_PUBLIC, "HelloWorld", null, "java/lang/Object", null);

        MethodVisitor mw = cw.visitMethod(
                ACC_PUBLIC | ACC_STATIC, "main",
                "([Ljava/lang/String;)V", null, null);

        mw.visitFieldInsn(GETSTATIC, "java/lang/System",
                "out", "Ljava/io/PrintStream;");

        mw.visitLdcInsn("Hello world!");

        mw.visitMethodInsn(INVOKEVIRTUAL,
                "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V", false);

        mw.visitInsn(RETURN);

        mw.visitMaxs(2, 2);
        mw.visitEnd();
        cw.visitEnd();

        byte[] bytes = cw.toByteArray();

        Path targetFile = Paths.get("HelloWorld.class");
        Files.write(targetFile, bytes);
    }
}
