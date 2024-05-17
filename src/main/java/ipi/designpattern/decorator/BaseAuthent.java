package ipi.designpattern.decorator;

public class BaseAuthent implements Authenticate {
    private User user;

    public BaseAuthent(User user) {
        this.user = user;
    }

    @Override
    public boolean authenticate() {
        if (user.getLogin() == null || user.getLogin().length() != 8) {
            return false;
        }
        if (user.getPassword() == null
                || !user.getPassword().matches(".*[0-9].*")
                || !user.getPassword().matches(".*[a-z].*")
                || !user.getPassword().matches(".*[A-Z].*")
                || !user.getPassword().matches(".*[!@#$%^&*(),.?:{}|<>].*")
                || !user.getPassword().matches(".*[\\x20-\\x7E].*")) {
            return false;
        }
        return true;
    }
}
