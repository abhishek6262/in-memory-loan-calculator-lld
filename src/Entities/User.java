package Entities;

public abstract class User {
    public String username;
    public String name;

    protected User(String username, String name) {
        this.username = username;
        this.name = name;
    }
}
