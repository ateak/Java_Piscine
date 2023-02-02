package edu.day01.ex01;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Tanya", 500);
        System.out.println(user1.getIdentifier());
        User user2 = new User("Katya", 500);
        System.out.println(user2.getIdentifier());
        User user3 = new User("Nastya", 500);
        System.out.println(user3.getIdentifier());
    }
}

