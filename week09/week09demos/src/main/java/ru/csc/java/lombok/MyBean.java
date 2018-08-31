package ru.csc.java.lombok;

import lombok.Data;

@Data(staticConstructor = "of")
public class MyBean {

    private final String a;
    private final String b;
}
