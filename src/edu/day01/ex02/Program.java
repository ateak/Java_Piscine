package edu.day01.ex02;

public class Program {
    public static void main(String[] args) {
        UsersList ArrayList = new UsersArrayList();
        ArrayList.UserAdd("Tanya", 100);
        ArrayList.UserAdd("Katya", 200);
        ArrayList.UserAdd("Nastya", 300);
        ArrayList.UserAdd("Jenya", 400);
        ArrayList.UserAdd("Yana", 500);

        System.out.println(ArrayList.UsersNum());
        for (int i = 0; i < ArrayList.UsersNum(); i++) {
            System.out.println(ArrayList.UserByIndex(i).getName());
        }
        System.out.println(ArrayList.UserById(4).getName());
    }
}


