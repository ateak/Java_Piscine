package edu.day01.ex00;

public class Program {
    public static void main(String[] args) {
        User Tanya = new User("Tanya", 100, 0);
        User Katya = new User("Katya", 300, 1);

        Transaction t1 = new Transaction(Tanya, Katya, -50);
        System.out.println(t1);

        Transaction t2 = new Transaction(Tanya, Katya, 100);
        System.out.println(t2);
    }
}