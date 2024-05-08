import java.util.*;

public class RegularUserRepository {
    private Map<String, RegularUser> users;

    public RegularUserRepository() {
        users = new HashMap<>();
    }

    public boolean addUser(RegularUser user) {
        if (validateUser(user)) {
            users.put(user.getEmail(), user);
            return true;
        }
        return false;
    }

    public boolean updateUser(String email, RegularUser updatedUser) {
        if (users.containsKey(email) && validateUser(updatedUser)) {
            users.put(email, updatedUser);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String email) {
        if (users.containsKey(email)) {
            users.remove(email);
            return true;
        }
        return false;
    }

    public RegularUser getUser(String email) {
        return users.get(email);
    }

    public List<RegularUser> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    private boolean validateUser(RegularUser user) {
        UserValidator validator = new UserValidator();
        return validator.validateEmail(user.getEmail()) &&
                validator.validatePassword(user.getPassword()) &&
                validator.validateAddress(user.getAddress());
    }
}