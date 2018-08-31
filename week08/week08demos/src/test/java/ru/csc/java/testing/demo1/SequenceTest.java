package ru.csc.java.testing.demo1;


import org.junit.jupiter.api.*;

public class SequenceTest {

    public SequenceTest() {
        System.err.println("constructor");
    }

    @BeforeAll
    public static void init() throws Exception {
        System.err.println("init");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.err.println("setUp");
    }

    @Test
    public void test1() throws Exception {
        System.err.println("test1");
    }

    @Test
    public void test2() throws Exception {
        System.err.println("test2");
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.err.println("tearDown");
    }

    @AfterAll
    public static void finish() throws Exception {
        System.err.println("finish");
    }
}
