package com.itschool.library.utils.exam_recap;
/*
 * Reverse a String
 * Write a program that takes a string input from the console and prints its reverse.
 */

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();
        scanner.close();

        System.out.println("Reversed string: " + reversed);
    }
}
