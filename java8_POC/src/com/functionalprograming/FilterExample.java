package com.functionalprograming;

import java.util.Arrays;
import java.util.List;

/*filters*/
public class FilterExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Sri", "latha", "venu", "Shreyansh");

        names.stream().filter(FilterExample::isSame).forEach(System.out::println);
        
        names.stream()
        .filter(FilterExample::isNotSame)
        .forEach(System.out::println);
        
        names.stream()
        .filter(name -> name.startsWith("S"))
        .forEach(System.out::println);

    }

    private static boolean isSame(String name) {
        return name.equals("Sri");
    }
    private static boolean isNotSame(String name) {
        return !name.equals("Sri");
    }
}
