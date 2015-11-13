package pint;

public class User {

    private final long id;
    private final String username;
    private final String email;

    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return "My name is " + username + " and my email is " + email;
    }
}
