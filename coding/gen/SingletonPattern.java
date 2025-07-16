package coding.gen;

public class SingletonPattern {

    private String username = "PAkistan";
    private String password = "Zindabad";
    private static SingletonPattern singletonPattern;

    private SingletonPattern() {
    }

    public static SingletonPattern getInstance() {
        if (singletonPattern == null) {
            singletonPattern = new SingletonPattern();
        }
        return singletonPattern;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        System.out.println(SingletonPattern.getInstance().getUsername());
        System.out.println(SingletonPattern.getInstance().getPassword());
    }
}
