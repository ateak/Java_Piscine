package edu.day01.ex01;

public class UserIdsGenerator {
    private int id;
    private static final UserIdsGenerator instance = new UserIdsGenerator();

    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        return instance;
    }

    public int generateId() {
        ++id;
        return id;
    }
}
