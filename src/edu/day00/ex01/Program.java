package edu.day00.ex01;

import java.util.Scanner;

public class Program {
    static void checkPrimeNum(int num) {
        boolean isPrime;
        int check = 2;
        while (check * check <= num && num % check != 0) {
            check++;
        }
        isPrime = check * check > num;
        System.out.println(isPrime + " " + (check - 1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number: \n");
        int num = in.nextInt(); //nextInt(): считывает введенное число int
        if (num <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        checkPrimeNum(num);
    }
}