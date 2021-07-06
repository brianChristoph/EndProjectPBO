package model;

/**
 *
 * @author Axell Silvano;
 */
public class UserManager {

    private static UserManager instance;
    private User user;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
