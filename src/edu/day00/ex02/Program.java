package edu.day00.ex02;

import java.util.Scanner;

public class Program {

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return (sum);
    }

    private static boolean checkPrimeNum(int num) {
        boolean isPrime;
        int check = 2;
        while (check * check <= num && num % check != 0) {
            check++;
        }
        isPrime = check * check > num;
        return (isPrime);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int coffeeCount = 0;
        int num = in.nextInt(); //nextInt(): считывает введенное число int
        while(num != 42) {
            if (num <= 1) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            if (checkPrimeNum(sumOfDigits(num))) {
                coffeeCount++;
            }
            num = in.nextInt();
        }
        System.out.println("Count of coffee-request - " + coffeeCount);
    }
}