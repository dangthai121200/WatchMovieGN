package org.example;

public class JVM {
    public static void main(String[] args) {
        Class c = JVM.class;
        System.out.println(c.getClassLoader());
        System.out.println(String.class.getClassLoader());

    }
}
