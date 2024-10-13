package com.itschool.library.utils.exam_recap;

/*
 *ArrayList Example
 *Create a program that adds five names to an ArrayList and prints them out.
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice"); //0
        names.add("Joe");   //1
        names.add("Bob");   //2

        for (int index = 0; index < names.size(); index++) {
            System.out.println(names.get(index));
        }
    }
}