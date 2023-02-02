package edu.day01.ex01;

public class User {
    private Integer identifier;
    private String name;
    private Integer balance;

    public User(String name, Integer balance) {
        this.name = name;
        this.identifier = UserIdsGenerator.getInstance().generateId();;
        if (balance > 0) {
            this.balance = balance;
        }
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}